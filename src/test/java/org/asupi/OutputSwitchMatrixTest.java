package org.asupi;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OutputSwitchMatrixTest {
    @Test
    void test1(){
        OutputSwitchMatrix outputSwitchMatrix = new OutputSwitchMatrix();
        assertEquals(36, outputSwitchMatrix.getMatrix().size());
        outputSwitchMatrix.setPosition(29,4);
        assertEquals(4,outputSwitchMatrix.getPosition(29));
    }
    @Test
    void testSetMultiPosition(){
        PositionState positionState = new PositionState();
        positionState.setState("29:1,30:3,31:3,32:3");
        OutputSwitchMatrix outputSwitchMatrix = new OutputSwitchMatrix();
        outputSwitchMatrix.changeState(positionState);
        assertEquals(1,outputSwitchMatrix.getPosition(29));
        assertEquals(3,outputSwitchMatrix.getPosition(30));
        assertEquals(3,outputSwitchMatrix.getPosition(31));
        assertEquals(3,outputSwitchMatrix.getPosition(32));

        outputSwitchMatrix.changeState(new PositionState("29:2,30:3,31:4,41:5"));
        assertEquals(2,outputSwitchMatrix.getPosition(29));
        assertEquals(3,outputSwitchMatrix.getPosition(30));
        assertEquals(4,outputSwitchMatrix.getPosition(31));
        assertEquals(5,outputSwitchMatrix.getPosition(41));


    }

}