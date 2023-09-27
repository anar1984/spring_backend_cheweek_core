package com.cheweek.spring_backend_cheweek_core.utility.core;

import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CallService {
    private final ApiClientService clientService;

    public Carrier callService(Carrier carrier, String service, String apiUri){
        Carrier rs = clientService.sendPostRequest(carrier,service,apiUri).blockOptional().orElseThrow();
        return  rs ;

    }
}