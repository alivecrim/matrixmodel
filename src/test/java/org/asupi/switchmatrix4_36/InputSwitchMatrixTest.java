package org.asupi.switchmatrix4_36;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputSwitchMatrixTest {
    @Test
    void test1() {
        InputSwitchMatrix inputSwitchMatrix = new InputSwitchMatrix(1);
        assertEquals(7, inputSwitchMatrix.getMatrix().size());
        inputSwitchMatrix.setPosition(1, 4);
        assertEquals(4, inputSwitchMatrix.getPosition(1));
    }

    @Test
    void testSetMultiPosition() {
        PositionState positionState = new PositionState();
        positionState.setState("1:1,2:3,3:4,5:6");
        InputSwitchMatrix inputSwitchMatrix = new InputSwitchMatrix(1);
        inputSwitchMatrix.changeState(positionState);
        assertEquals(1, inputSwitchMatrix.getPosition(1));
        assertEquals(3, inputSwitchMatrix.getPosition(2));
        assertEquals(4, inputSwitchMatrix.getPosition(3));
        assertEquals(6, inputSwitchMatrix.getPosition(5));

        inputSwitchMatrix.changeState(new PositionState("1:6,2:3,3:4,5:6"));
        assertEquals(6, inputSwitchMatrix.getPosition(1));
        assertEquals(3, inputSwitchMatrix.getPosition(2));
        assertEquals(4, inputSwitchMatrix.getPosition(3));
        assertEquals(6, inputSwitchMatrix.getPosition(5));


    }
}