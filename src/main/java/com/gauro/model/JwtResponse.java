package com.gauro.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Chandra
 */

@Data
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -2797759419130909390L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }
}
