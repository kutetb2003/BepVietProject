package com.bepviet.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class ProhibidoFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
//        if (request.getHeader("x-prohibido").equals("si")) {
//            response.getWriter().write("Acceso prohibido por el filtro");
//            response.setStatus(HttpStatus.FORBIDDEN.value());
//            return;
//        }
        filterChain.doFilter(request, response);
    }
}
