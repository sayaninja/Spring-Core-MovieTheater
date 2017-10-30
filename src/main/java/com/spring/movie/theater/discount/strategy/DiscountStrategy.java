package com.spring.movie.theater.discount.strategy;

import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.User;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

public interface DiscountStrategy {
    byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets);
}
