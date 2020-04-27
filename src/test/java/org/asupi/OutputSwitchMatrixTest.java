package org.asupi;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OutputSwitchMatrixTest {
    @Test
    void test1(){
        OutputSwitchMatrix outputSwitchMatrix = new OutputSwitchMatrix();
        assertEquals(36, outputSwitchMatrix.getMatrix().size());
        outputSwitchMatrix.setPosition(1,4);
        assertEquals(4,outputSwitchMatrix.getPosition(1));
    }
    @Test
    void testSetMultiPosition(){
        PositionState positionState = new PositionState();
        positionState.setState("1:1,2:3,5:3,9:3");
        OutputSwitchMatrix outputSwitchMatrix = new OutputSwitchMatrix();
        outputSwitchMatrix.changeState(positionState);
        assertEquals(-1,outputSwitchMatrix.getPosition(1));
        assertEquals(-1,outputSwitchMatrix.getPosition(2));
        assertEquals(-1,outputSwitchMatrix.getPosition(5));
        assertEquals(-1,outputSwitchMatrix.getPosition(9));

        outputSwitchMatrix.changeState(new PositionState("1:2,2:3,3:4,4:5"));
        assertEquals(2,outputSwitchMatrix.getPosition(1));
        assertEquals(3,outputSwitchMatrix.getPosition(2));
        assertEquals(4,outputSwitchMatrix.getPosition(3));
        assertEquals(5,outputSwitchMatrix.getPosition(4));


    }

}