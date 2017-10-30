package com.spring.movie.theater.domain;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Optional;

@Data
@Builder
public class User extends DomainObject {

    String firstName;
    String lastName;
    String email;
    NavigableSet<Ticket> tickets;
    LocalDateTime birthday;

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (email == null) {
            if (other.email != null) {
                return false;
            }
        } else if (!email.equals(other.email)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }

    public Optional<LocalDateTime> getBirthday() {
        return Optional.ofNullable(birthday);
    }
}
