package com.cheweek.spring_backend_cheweek_core.utility.core;

import com.cheweek.spring_backend_cheweek_core.utility.exception.ConverterException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CallService {
    private final ApiClientService clientService;

    public Object callService(Object carrier, String service, String apiUri) {
        Object rs = clientService.sendPostRequest(carrier, service, apiUri).blockOptional().orElseThrow();
        return rs;

    }

    public Object callServiceToDto(Object carrier, String service, String apiUri,Object dto){
        ModelMapper mapper = new ModelMapper();
        try {
            dto = mapper.map(clientService.sendPostRequest(carrier, service, apiUri), dto.getClass());
            return dto;
        } catch (Exception ex) {
            ConverterException converterException = new ConverterException();
            converterException.setErrorType("error");
            converterException.setMessageCode("chw-" + converterException.getStatusCode());
            converterException.setMessage("Convert exception");
            throw new ConverterException();
        }
    }
}