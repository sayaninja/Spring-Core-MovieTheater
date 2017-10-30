package com.spring.movie.theater.discount;

import com.spring.movie.theater.domain.User;
import org.springframework.stereotype.Component;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

@Component
public class BirthdayDiscount {
    // give 5% if user has birthday within 5 days of air date
    private static final byte NO_DISCOUNT = 0;
    private static final byte DISCOUNT = 50;
    private static final int BIRTHDAY_RANGE = 5;

    public byte getDiscount(@Nullable User user, @Nonnull LocalDateTime airDateTime) {
        return user.getBirthday().isPresent() &&
                Math.abs(airDateTime.getDayOfMonth() - user.getBirthday().get().getDayOfMonth()) < BIRTHDAY_RANGE ?
                DISCOUNT : NO_DISCOUNT;
    }
}
