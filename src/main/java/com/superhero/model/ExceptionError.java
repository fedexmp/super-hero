package com.superhero.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionError {
    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
