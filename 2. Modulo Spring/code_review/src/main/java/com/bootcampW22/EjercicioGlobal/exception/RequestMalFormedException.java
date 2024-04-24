
package com.bootcampW22.EjercicioGlobal.exception;


public class RequestMalFormedException  extends RuntimeException {

    public RequestMalFormedException(String message){
        super(message);
    }
}