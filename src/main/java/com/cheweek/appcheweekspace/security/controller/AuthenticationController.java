package com.cheweek.appcheweekspace.security.controller;

import com.cheweek.appcheweekspace.security.model.JwtRequest;
import com.cheweek.appcheweekspace.security.model.JwtResponse;
import com.cheweek.appcheweekspace.security.model.TestDto;
import com.cheweek.appcheweekspace.security.service.AuthService;
import com.cheweek.appcheweekspace.utility.QLogger;
import com.cheweek.appcheweekspace.utility.core.CallService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Log4j2
public class AuthenticationController {
    private final AuthService service;
    private final CallService clientService;
    final QLogger logger = QLogger.getLogger(AuthenticationController.class);
    @PostMapping("/authentication")
    public ResponseEntity<JwtResponse> authentication(@RequestBody JwtRequest request) throws Exception {
        return  ResponseEntity.ok(service.createAuthenticationToken(request)) ;

    }

    @PostMapping("/authorization")
    public ResponseEntity<?> authorization(@RequestBody TestDto token) throws Exception {
        return  ResponseEntity.ok(token) ;

    }
    @GetMapping("/test")
    public ResponseEntity<?> testGet() throws Exception {
        return  ResponseEntity.ok("test") ;

    }
    @PostMapping("/call/**")
    public ResponseEntity<?> callService(@RequestBody Object carrier
                                                  , HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        String[] list = uri.substring(1).split("/");
        log.info("uriController "+uri);
        int startIndex = list[0].length() +list[1].length()+list[2].length()+list[3].length()+list[4].length();
        final String service= list[4];
        log.info("serviceController "+service);
        final String apiUri = uri.substring(startIndex+2);
        log.info("apiUriController "+apiUri);

        return  ResponseEntity.ok(clientService.callService(
                carrier,
                service,
                apiUri
        )) ;

    }

}
