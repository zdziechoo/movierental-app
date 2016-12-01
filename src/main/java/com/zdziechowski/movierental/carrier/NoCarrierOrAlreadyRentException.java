package com.zdziechowski.movierental.carrier;
public class NoCarrierOrAlreadyRentException extends RuntimeException {
    public String getMessage() {
        return "No carrier in the collection or already rent";
    }
}
