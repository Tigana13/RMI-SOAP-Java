package com.baeldung.client;

import com.baeldung.api.Booking;
import com.baeldung.api.BookingException;
import com.baeldung.api.CabBookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication public class RmiClient {

    @Bean
    RmiProxyFactoryBean service() {
        RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
        rmiProxyFactory.setServiceUrl("rmi://localhost:1001/CabBookingService");
        rmiProxyFactory.setServiceInterface(CabBookingService.class);
        return rmiProxyFactory;
    }

    public static void main(String[] args) throws BookingException {
        CabBookingService service = SpringApplication.run(RmiClient.class, args).getBean(CabBookingService.class);
        Booking bookingOutcome = service.bookRide("213 Ole Sangale Road, Next to Strathmore University");
        System.out.println(bookingOutcome);
    }

}
