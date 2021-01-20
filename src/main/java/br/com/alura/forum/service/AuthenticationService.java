package br.com.alura.forum.service;

import br.com.alura.forum.controller.request.LoginRequest;
import br.com.alura.forum.model.User;
import br.com.alura.forum.repository.UserRepository;
import io.swagger.models.Response;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile(value = {"prod", "test"})
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationService {

    private final AuthenticationManager authManager;

    private final TokenService tokenService;

    private final UserRepository userRepository;

    public ResponseEntity<?> authenticate(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken loginData = loginRequest.convert();

        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
        if (user.isPresent()) {
            try {
                Authentication authentication = authManager.authenticate(loginData);
                String token = tokenService.createToken(authentication);

                return ResponseEntity.ok().body(token);
            }
            catch (AuthenticationException e) {
                return ResponseEntity.badRequest().build();
            }
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}
