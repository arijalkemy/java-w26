package meli.bootcamp.hql.authentication;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.hql.config.JwtService;
import meli.bootcamp.hql.model.Role;
import meli.bootcamp.hql.model.User;
import meli.bootcamp.hql.repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final IUserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();

    userRepository.save(user);

    var jwt = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }

  public AuthenticationResponse login(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );

    var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow();

    var jwt = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();

  }
}
