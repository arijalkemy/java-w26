package org.example.templatemvc.Common.Errors;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("not found");
    }

    public NotFoundException(String entity) {
        super(entity + " not found");
    }

    public NotFoundException(String entity, String param) {
        super(entity + " not found >> " + param);
    }
}
