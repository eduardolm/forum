package br.com.alura.forum.service;

import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class AuthTokenFilterService extends OncePerRequestFilter {

    private TokenService tokenService;

    public AuthTokenFilterService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = retrieveToken(request);
        boolean valid = tokenService.isValidToken(token);
        filterChain.doFilter(request, response);
    }

    private String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || token.isBlank() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7);
    }
}
