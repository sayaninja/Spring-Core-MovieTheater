package com.spring.movie.theater.discount;

import com.spring.movie.theater.domain.Event;
import com.spring.movie.theater.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

@Component
public class DefaultDiscountService implements DiscountService {

    @Autowired
    DefaultDiscountStrategy discountStrategy;

    @Override
    public byte getDiscount(@Nullable User user, @Nonnull Event event, @Nonnull LocalDateTime airDateTime, long numberOfTickets) {
        return discountStrategy.getDiscount(user, event, airDateTime, numberOfTickets);
    }
}
