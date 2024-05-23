package org.ggomezr.showroomelasticsearch.domain.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
