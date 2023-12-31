package az.namazov.bookkeeping.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.namazov.bookkeeping.config.security.jwt.JwtTokenProvider;
import az.namazov.bookkeeping.controller.response.AuthResponse;
import az.namazov.bookkeeping.dto.AuthenticationRequestDTO;
import az.namazov.bookkeeping.entity.User;
import az.namazov.bookkeeping.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthenticationRequestDTO auth) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserPassword(), auth.getUserPassword()));
        User user = userService.findByUsername(auth.getUserName());
        String token = jwtTokenProvider.createToken(user);
        AuthResponse response = new AuthResponse();
        response.setUserName(user.getUserName());
        response.setToken(token);
        return ResponseEntity.ok(response);
    }
}
