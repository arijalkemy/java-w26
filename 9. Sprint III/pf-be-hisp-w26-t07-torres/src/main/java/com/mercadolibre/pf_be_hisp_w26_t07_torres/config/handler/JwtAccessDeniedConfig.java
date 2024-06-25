package com.mercadolibre.pf_be_hisp_w26_t07_torres.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.AuthException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;
import java.io.Writer;

@Configuration
public class JwtAccessDeniedConfig implements AccessDeniedHandler {
    private final ObjectWriter objectWriter;

    public JwtAccessDeniedConfig() {
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        Writer writer = response.getWriter();
        AuthException exception = new AuthException(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
        writer.write(objectWriter.writeValueAsString(exception));
    }
}
