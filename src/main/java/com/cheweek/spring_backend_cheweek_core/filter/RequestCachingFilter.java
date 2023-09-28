package com.cheweek.spring_backend_cheweek_core.filter;

import com.cheweek.spring_backend_cheweek_core.utility.QLogger;
import com.cheweek.spring_backend_cheweek_core.utility.SessionManager;
import com.cheweek.spring_backend_cheweek_core.utility.UserInfo;
import com.cheweek.spring_backend_cheweek_core.utility.core.RedisService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Order(value = Ordered.LOWEST_PRECEDENCE)
@Component
@WebFilter(filterName = "RequestCachingFilter", urlPatterns = "/*")
@RequiredArgsConstructor
public class RequestCachingFilter extends OncePerRequestFilter {

    private final SessionManager manager;
    private final RedisService redisService;


    final QLogger logger = QLogger.getLogger(RequestCachingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {



        String token= request.getHeader("Authorization");

        String land = request.getHeader("land");
        manager.setLang(land);
        manager.setToken(token);
        if(token== null || !token.startsWith("Bearer ")){
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "JWT Token has expired");
        }


        boolean check =  checkToken(token==null ? "" : token.substring(7));
        if(!check){
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Token is invalid");
            return;
        }

        filterChain.doFilter(request, response);
    }
    private boolean checkToken(String token){
        if (token.isEmpty()) {
            logger.info("Token is empty");
            return false;
        }
        UserInfo userInfo = getUserInfo(token);
        if (userInfo == null) {
            logger.info("token is invalid");
            return false;
        }
        if (userInfo != null) {
            setSession(userInfo,token);
            return true;

        }

        return true;
    }
    private UserInfo getUserInfo(String token) {
        UserInfo userInfo = new UserInfo();
        if (token.length() == 0) {
            return null;
        }
        userInfo = redisService.getRedis("chw.hashKeyToken",token);
        return userInfo;

    }
    private void setSession(UserInfo userInfo,String token) {

        manager.setCurrentUserId(userInfo.getCurrentUserId());
        manager.setCurrentUserName( userInfo.getCurrentUserName());
        manager.setCurrentThreadId(userInfo.getCurrentUserId());
        manager.setCurrentRoleId(userInfo.getCurrentRoleId());
        manager.setUserId(userInfo.getCurrentUserId());
        manager.setDomain(userInfo.getDomain());
        manager.setToken(token);
    }

}