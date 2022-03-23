package com.superhero.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserException extends RuntimeException {
    /**
     *Exception del controlador de usuarios
     */
    private static final long serialVersionUID = 1L;
    private String mensaje;
    private String path;

    public UserException( String mensaje, String path) {
        this.mensaje = mensaje;
        this.path = path;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getPath(){
        return path;
    }


}
