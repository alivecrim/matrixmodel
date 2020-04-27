package org.asupi;

import java.util.Objects;

public class Switch {
    private Integer number;
    private Integer position;

    public Switch() {
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Switch aSwitch = (Switch) o;
        return number.equals(aSwitch.number) &&
                position.equals(aSwitch.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

    public Switch(Integer number, Integer position) {
        this.number = number;
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Switch{" +
                "number=" + number +
                ", position=" + position +
                '}';
    }
}
