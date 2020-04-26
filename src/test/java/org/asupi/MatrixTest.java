package org.asupi;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {
    @Test
    void testInnerPosition(){
        MatrixModel matrixModel = new MatrixModel();


        matrixModel.setPosition(1,5);
        assertEquals(5,matrixModel.getOut(1));
    }


}