package com.w26.linktracker.exception;

import lombok.Getter;

public class RetriveLinkException extends RuntimeException {

    @Getter
    private Integer idToRetrive;
    public RetriveLinkException(String message, Integer idToRetrive) {
        super(message);
        this.idToRetrive = idToRetrive;
    }


}
