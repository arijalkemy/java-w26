package org.example.be_java_hisp_w26_g07.utils;

import lombok.Getter;

@Getter
public enum UserMessageError {
    CLIENT_NOT_FOUND("Cliente con id %d no encontrado"),
    SELLER_NOT_FOUND("Vendedor con id %d no encontrado"),
    USER_NOT_FOUND("Usuario con id %d no encontrado"),
    CLIENT_IS_NOT_SELLER("Existe el usuario pero no es vendedor"),
    ID_CLIENT_SELLER_IS_EQUALS("El id del usuario no puede ser igual al vendedor"),
    LIST_CLIENTE_ORDER("Orden de la lista no valido, orden validos: name_asc o name_desc"),
    LIST_CLIENT_NOT_FOUND(""),
    LIST_SELLER_NOT_FOUND(""),
    LIST_POST_NOT_FOUND("");
    private final String message;

    UserMessageError(String message) {
        this.message = message;
    }

    public String getMessage(Integer id) {
        return String.format(this.message, id);
    }
}
