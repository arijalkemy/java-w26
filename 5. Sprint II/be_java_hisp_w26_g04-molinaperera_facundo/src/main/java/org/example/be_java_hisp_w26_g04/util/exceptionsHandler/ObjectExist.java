package org.example.be_java_hisp_w26_g04.util.exceptionsHandler;

import org.example.be_java_hisp_w26_g04.exceptions.BadRequestException;

import java.util.Optional;

public class ObjectExist {
    public static <T> T getObjectFromOptional(Optional<T> object) {
        if (object.isEmpty()) throw new BadRequestException();
        return object.get();
    }
}
