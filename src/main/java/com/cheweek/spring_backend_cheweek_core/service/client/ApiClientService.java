package com.cheweek.spring_backend_cheweek_core.service.client;



import com.cheweek.spring_backend_cheweek_core.exception.ClientServiceException;
import com.cheweek.spring_backend_cheweek_core.service.core.PropertyService;
import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import com.cheweek.spring_backend_cheweek_core.utility.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiClientService {
    private final WebClient.Builder webClientBuilder;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private SessionManager sessionManager;


    public ApiClientService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Carrier> sendPostRequest(Carrier carrier, String serviceKey, String endPoint) {
        final String service = "service.";
        final String serviceUriKey = ".baseurl";
        final String contextPathKey = ".contextPath";
        String serviceUli = propertyService.getProperty(service + serviceKey + serviceUriKey);
        String contextPath = propertyService.getProperty(service + serviceKey + contextPathKey);
        String endPointUri = contextPath + endPoint;

        WebClient webClient = webClientBuilder
                .baseUrl(serviceUli)
                .defaultHeader("Authorization", sessionManager.getToken())
                .defaultHeader("Accept", "application/json")
                .build();
        return webClient.post()
                .uri(endPointUri)
                .bodyValue(carrier)
                .retrieve()
                .onRawStatus(status -> status == 400, clientResponse -> {
                    ClientServiceException exception = clientResponse.bodyToMono(ClientServiceException.class).block();
                    throw exception;
                })
                .onRawStatus(status -> status == 404, clientResponse -> {
                    ClientServiceException exception = new ClientServiceException();
                    exception.setLang(sessionManager.getLang());
                    exception.setErrorDetail("404 Not Found from POST Path" + serviceKey + " : " + endPoint);
                    exception.setError("404 Not Found from POST Path");
                    exception.setMessageCode("404");
                    exception.setMessage("404 Not Found from POST Path " + serviceKey + " : " + endPoint);
                    exception.setPath(serviceKey + " : " + endPoint);

                    throw exception;
                })
                .onRawStatus(status -> status == 500, clientResponse -> {

                    throw new RuntimeException("500 Internal Server Error \n " + serviceKey + " : " + endPoint);
                })
                .bodyToMono(Carrier.class);

    }
    public Carrier callService(Carrier carrier, String serviceKey, String endPoint){
        return sendPostRequest(carrier,serviceKey,endPoint).block();
    }
}


