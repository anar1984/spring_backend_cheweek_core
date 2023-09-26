package com.cheweek.spring_backend_cheweek_core.utility.factory;


import com.cheweek.spring_backend_cheweek_core.utility.Carrier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoreServiceManager {

    private final List<CoreService> services;
    public Carrier callService(Carrier carrier, String serviceName){

        for (CoreService service : services) {
            if (service.getClass().getSimpleName().equalsIgnoreCase(serviceName)) {
                return service.run(carrier);
            }
        }
        throw new IllegalArgumentException("Unknown service: " + serviceName);
    }
}
