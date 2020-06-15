package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class Seat implements Comparable<Seat> {

    @Column(nullable = false)
    private Character rowCharacter;

    @Column(nullable = false)
    private Integer placeNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return rowCharacter.equals(seat.rowCharacter) &&
                placeNumber.equals(seat.placeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowCharacter, placeNumber);
    }

    @Override
    public int compareTo(Seat seat) {
        if (this.getRowCharacter() - seat.getRowCharacter() == 0 && this.getPlaceNumber() == 0) {
            return 0;
        } else if (this.getRowCharacter() - seat.getRowCharacter() >= 0 && this.getPlaceNumber() - seat.getPlaceNumber() > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
