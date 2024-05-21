package org.example.joyeria.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JoyaNotFound extends RuntimeException {
    public JoyaNotFound(String message) {
        super(message);
    }
}
