package com.mercadolibre.final_project_java_hisp_w26_t6.services.authentication;

import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.LoginRequestDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.dtos.LoginResponseDto;
import com.mercadolibre.final_project_java_hisp_w26_t6.entity.User;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.BadCredentialsException;
import com.mercadolibre.final_project_java_hisp_w26_t6.exceptions.NotFoundException;
import com.mercadolibre.final_project_java_hisp_w26_t6.repository.IUsersRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class AuthServiceImpl implements IAuthService {

    private final int JWT_TOKEN_TIME_MINUTES = 60;

    @Autowired
    IUsersRepository usersRepository;

    @Autowired
    SecretKey secretKey;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequest) {

        User user = usersRepository.findByUsername(loginRequest.getUsername());

        if (user == null){
            throw new NotFoundException("El usuario no existe");
        }

        if(!checkPassword(loginRequest.getPassword(), user.getHashedPassword())){
            throw new BadCredentialsException("Credenciales inválidas");
        }

        // Tiempo actual (milisegundos) +
        // 60 (min) * 60 (Segundos/min) = 3600 segundos *  1000 ( Milisegundos/segundo ) = 3.600.000 milisegundos
        String jwtToken = Jwts.builder()
                .setSubject(loginRequest.getUsername())
                .claim("rol", user.getUserRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_TIME_MINUTES * 60 * 1000))
                .signWith(secretKey, SignatureAlgorithm.HS256).compact();

        return new LoginResponseDto(jwtToken);
    }

    private boolean checkPassword(String password, String passwordDB) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean passwordMatch = passwordEncoder.matches(password, passwordDB);
        return passwordMatch;
    }


}
