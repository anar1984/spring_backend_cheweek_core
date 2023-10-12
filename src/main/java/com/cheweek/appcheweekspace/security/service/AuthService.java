package com.cheweek.appcheweekspace.security.service;

import com.cheweek.appcheweekspace.utility.UserInfo;
import com.cheweek.appcheweekspace.utility.core.PropertyService;
import com.cheweek.appcheweekspace.utility.core.RedisServiceUser;
import com.cheweek.appcheweekspace.security.model.JwtRequest;
import com.cheweek.appcheweekspace.security.model.JwtResponse;
import com.cheweek.appcheweekspace.security.model.User;
import com.cheweek.appcheweekspace.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RedisServiceUser redisServiceUser;
    @Autowired
    private PropertyService propertyService;


    public JwtResponse createAuthenticationToken(JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());


        final User userDetails =userService.
                login(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(userDetails);
        UserInfo info = new UserInfo();
        info.setKey("");
        info.setCurrentUserId(userDetails.getId());
        info.setCurrentUserName(userDetails.getUsername());
        redisServiceUser.setRedis(propertyService.getProperty("chw.hashKeyToken"),token,info);
        return new JwtResponse(token);
    }


    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    public JwtResponse checkToken( JwtResponse token) {
         return token;
    }
}
