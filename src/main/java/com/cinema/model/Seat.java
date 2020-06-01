package com.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class Seat implements Comparable<Seat> {

    private Character rowCharacter;

    private Integer placeNumber;

    public Seat(char rowCharacter, int placeNumber) {
        this.rowCharacter = rowCharacter;
        this.placeNumber = placeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return rowCharacter == seat.rowCharacter &&
                placeNumber == seat.placeNumber;
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
