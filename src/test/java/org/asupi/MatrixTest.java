package org.asupi;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {
    @Test
    void testInnerPosition(){
        MatrixModel matrixModel = new MatrixModel();

        matrixModel.setPosition(2,15);
        assertEquals(15,matrixModel.getOut(2));
    }


}