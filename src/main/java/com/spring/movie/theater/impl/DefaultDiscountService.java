package com.spring.movie.theater.impl;

import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.User;
import com.spring.movie.theater.discount.DiscountService;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

public class DefaultDiscountService implements DiscountService {
    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        return 0;
    }
}
