package com.baeldung.server;

import com.baeldung.api.Booking;
import com.baeldung.api.BookingException;
import com.baeldung.api.CabBookingService;

import static java.lang.Math.random;
import static java.util.UUID.randomUUID;

public class CabBookingServiceImpl implements CabBookingService {

    @Override public Booking bookRide(String pickUpLocation) throws BookingException {
        if (random() < 0.3) throw new BookingException("Sorry, there are no cabs available at this moment");
        return new Booking(randomUUID().toString());
    }
}
