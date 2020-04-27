package org.asupi;

import org.asupi.switchmatrix4_36.Switch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwitchTest {
    Switch Sswitch;

    @BeforeEach
    void setUp() {
        Sswitch = new Switch(1, 3);
    }

    @Test
    void getSetNumber() {
        assertEquals(1, Sswitch.getNumber());
        Sswitch.setNumber(4);
        assertEquals(4, Sswitch.getNumber());

    }

    @Test
    void getSetPosition() {
        assertEquals(3, Sswitch.getPosition());
        Sswitch.setPosition(4);
        assertEquals(4, Sswitch.getPosition());
    }

    @Test
    void testEquals(){
        assertEquals(new Switch(1,1),new Switch(1,1));
    }
}