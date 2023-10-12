package com.cheweek.appcheweekspace.erp.controller;


import com.cheweek.appcheweekspace.utility.Carrier;
import com.cheweek.appcheweekspace.utility.factory.CoreServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class CoreController {

    private final CoreServiceManager coreServiceTest;
    @PostMapping("/service/{apiId}")
    public Carrier callService(@RequestBody Carrier carrier, @PathVariable String  apiId){
        return coreServiceTest.callService(carrier,apiId);
    }

}
