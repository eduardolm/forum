package br.com.alura.forum.controller;

import br.com.alura.forum.controller.request.LoginRequest;
import br.com.alura.forum.dto.TokenDto;
import br.com.alura.forum.model.User;
import br.com.alura.forum.service.AuthenticationService;
import br.com.alura.forum.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@Profile(value = {"prod", "test"})
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationController {

    private final AuthenticationService authService;

    private final UserService userService;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginRequest loginRequest) {
        Optional<User> user = userService.findByEmail(loginRequest.getEmail());

        if (user.isPresent()) {
            String token = Objects.requireNonNull(authService.authenticate(loginRequest).getBody()).toString();

            return ResponseEntity.ok(new TokenDto("Bearer", token));
        }
        else {

            throw new NoSuchElementException("User not found.");
        }

    }
}
