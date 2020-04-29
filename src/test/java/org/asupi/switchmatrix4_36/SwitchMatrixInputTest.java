package org.asupi.switchmatrix4_36;

import org.asupi.switchmatrix4_36.switchmatrixio.SwitchMatrix;
import org.asupi.switchmatrix4_36.switchmatrixio.SwitchMatrixInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchMatrixInputTest {
    @Test
    void test1() {
        SwitchMatrix switchMatrixInput = new SwitchMatrixInput(1);
        assertEquals(7, switchMatrixInput.getMatrix().size());
        switchMatrixInput.setPosition(1, 4);
        assertEquals(4, switchMatrixInput.getPosition(1));
    }

    @Test
    void testSetMultiPosition() {
        PositionState positionState = new PositionState();
        positionState.setState("1:1,2:3,3:4,5:6");
        SwitchMatrix switchMatrixInput = new SwitchMatrixInput(1);
        switchMatrixInput.changeState(positionState);
        assertEquals(1, switchMatrixInput.getPosition(1));
        assertEquals(3, switchMatrixInput.getPosition(2));
        assertEquals(4, switchMatrixInput.getPosition(3));
        assertEquals(6, switchMatrixInput.getPosition(5));

        switchMatrixInput.changeState(new PositionState("1:6,2:3,3:4,5:6"));
        assertEquals(6, switchMatrixInput.getPosition(1));
        assertEquals(3, switchMatrixInput.getPosition(2));
        assertEquals(4, switchMatrixInput.getPosition(3));
        assertEquals(6, switchMatrixInput.getPosition(5));
    }
}