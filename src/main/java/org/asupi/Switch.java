package org.asupi;

public class Switch {
    private Integer number;
    private Integer position;

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
}
