package org.asupi.switchmatrix4_36;

import org.asupi.switchmatrix4_36.switchmatrixio.SwitchMatrix;
import org.asupi.switchmatrix4_36.switchmatrixio.SwitchMatrixOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwitchMatrixOutputTest {
    @Test
    void test1(){
        SwitchMatrix switchMatrixOutput = new SwitchMatrixOutput();
        assertEquals(36, switchMatrixOutput.getMatrix().size());
        switchMatrixOutput.setPosition(29, 4);
        assertEquals(4, switchMatrixOutput.getPosition(29));
    }
    @Test
    void testSetMultiPosition(){
        PositionState positionState = new PositionState();
        positionState.setState("29:1,30:3,31:3,32:3");
        SwitchMatrix switchMatrixOutput = new SwitchMatrixOutput();
        switchMatrixOutput.changeState(positionState);
        assertEquals(1, switchMatrixOutput.getPosition(29));
        assertEquals(3, switchMatrixOutput.getPosition(30));
        assertEquals(3, switchMatrixOutput.getPosition(31));
        assertEquals(3, switchMatrixOutput.getPosition(32));

        switchMatrixOutput.changeState(new PositionState("29:2,30:3,31:4,41:5"));
        assertEquals(2, switchMatrixOutput.getPosition(29));
        assertEquals(3, switchMatrixOutput.getPosition(30));
        assertEquals(4, switchMatrixOutput.getPosition(31));
        assertEquals(5, switchMatrixOutput.getPosition(41));
    }

}