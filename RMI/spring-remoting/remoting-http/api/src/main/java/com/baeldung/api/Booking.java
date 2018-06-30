package com.baeldung.api;

import java.io.Serializable;

import static java.lang.String.format;

public class Booking implements Serializable {
    private String bookingCode;

    @Override public String toString() {
        return format("Your ride has been confirmed: CODE: '%s'.", bookingCode);
    }

    public Booking(String bookingCode) {
        this.bookingCode = bookingCode;
    }
}
