package com.zdziechowski.movierental.console;

public class InvalidOptionException extends RuntimeException {
    public String getMessage() {
        return "Invalid option";
    }

}
