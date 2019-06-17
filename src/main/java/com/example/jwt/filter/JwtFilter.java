package com.example.jwt.filter;

import com.example.jwt.uitl.JwtUitl;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


@WebFilter(urlPatterns = "/*")
@Component
public class JwtFilter extends GenericFilterBean {
    private static final List<String> WHITE_LIST = Collections.singletonList("/login/registration");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String jwt = httpServletRequest.getHeader("Authorization");
        if (WHITE_LIST.contains(httpServletRequest.getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (jwt!=null) {
            if(JwtUitl.isTokenValid(jwt.substring(7))){
                updateToken(httpServletResponse, jwt.substring(7));
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private void updateToken(HttpServletResponse httpServletResponse, String jwt) {
        String payload = JwtUitl.parseToken(jwt);
        String newToken = JwtUitl.generateToken(payload);
        httpServletResponse.setHeader("Authorization", newToken);
    }

}
