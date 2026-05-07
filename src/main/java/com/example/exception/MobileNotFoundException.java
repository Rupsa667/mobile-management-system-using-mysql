package com.example.exception;

public class MobileNotFoundException  extends   RuntimeException {
    public MobileNotFoundException(String message) {
        super(message);
    }
}
