package com.cheweek.appcheweekspace.security.filter;

import com.cheweek.appcheweekspace.utility.QLogger;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements Filter {
    final QLogger logger = QLogger.getLogger(CorsConfig.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest)req;
        logger.info("pro");
        String dev = request.getHeader("dev") == null ? "" : request.getHeader("dev");
        if(dev.trim().length()!=0){
            chain.doFilter(req, res);
            return;
        }
        logger.info("pro2");
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, enctype");
        response.setHeader("Access-Control-Max-Age", "3600");
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }


    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }
}
