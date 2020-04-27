package org.asupi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionStateTest {
    @Test
    void positionStateTest(){
        PositionState positionState = new PositionState();
        positionState.setState("1:1");
        assertEquals(1, positionState.getState().get(1));
    }

}