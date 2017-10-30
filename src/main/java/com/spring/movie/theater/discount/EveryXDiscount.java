package com.spring.movie.theater.discount;

import org.springframework.stereotype.Component;

@Component
public class EveryXDiscount {
    private static double DISCOUNT = 50; // 50% discount for every Xth ticket
    private static int X = 10; // number of the ticket for which discount will be given

    public byte getDiscount(long numberOfTickets) {
        return (byte) (numberOfTickets / X * DISCOUNT);
    }
}
