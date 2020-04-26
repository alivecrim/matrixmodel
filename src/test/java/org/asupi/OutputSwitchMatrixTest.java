package org.asupi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputSwitchMatrixTest {
    @Test
    void test1(){
        OutputSwitchMatrix outputSwitchMatrix = new OutputSwitchMatrix();
        assertEquals(36, outputSwitchMatrix.getMatrix().size());
        outputSwitchMatrix.setPosition(1,4);
        assertEquals(4,outputSwitchMatrix.getPosition(1));
    }

}