package br.com.alura.forum.service;

import br.com.alura.forum.controller.request.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationService {

    private final AuthenticationManager authManager;

    private final TokenService tokenService;

    public ResponseEntity<?> authenticate(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken loginData = loginRequest.convert();

        try {
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.createToken(authentication);

            return ResponseEntity.ok().body(token);
        }
        catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
