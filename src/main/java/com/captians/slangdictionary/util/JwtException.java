package com.captians.slangdictionary.util;

@SuppressWarnings("serial")
public class JwtException extends RuntimeException {

    public static JwtException invalidAccessToken(String message) {
        return new JwtException(message, null);
    }

    public static JwtException invalidClaims(String message, Throwable cause) {
        return new JwtException(message, cause);
    }

    private JwtException(String message, Throwable cause) {
        super(message, cause);
    }
}
