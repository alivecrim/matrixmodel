package org.asupi.switchmatrix4_36;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {
    @Test
    void testInnerPosition() {
        MatrixModel matrixModel = new MatrixModelImpl();

        matrixModel.setPositionSingleSwitch(2, 5);
        assertEquals(5,matrixModel.getPosition(2));
        matrixModel.setPositionSingleSwitch(1, 32);
        assertEquals(32, matrixModel.getPosition(1));
        matrixModel.setPositionSingleSwitch(3, 19);
        assertEquals(19, matrixModel.getPosition(3));
        matrixModel.setPositionSingleSwitch(4, 11);
        assertEquals(11, matrixModel.getPosition(4));
    }
    @Test
    void testComparator(){
        MatrixModel matrixModel = new MatrixModelImpl();
        MatrixModel matrixModel1 = new MatrixModelImpl();

        matrixModel1.setPositionSingleSwitch(1, 32);
        matrixModel1.setPositionSingleSwitch(2, 33);
        matrixModel1.setPositionSingleSwitch(3, 34);
        matrixModel1.setPositionSingleSwitch(4, 35);
        List<Switch> diff = matrixModel.compareMatrix(matrixModel1);
        assertEquals(12, diff.size());
        assertEquals(new Switch(1,6), diff.get(0));
        System.out.println(diff);
    }

    @Test
    void setStateTest(){
        MatrixModel matrixModel = new MatrixModelImpl();
        matrixModel.setState(new PositionState("8:2,10:4,38:2"));
        assertEquals(10,matrixModel.getPosition(1));
    }

    @Test
    void getStateTest(){
        MatrixModel matrixModel = new MatrixModelImpl();
        matrixModel.setState(new PositionState("8:2,10:4,38:2"));
        MatrixModel matrixModel1 = new MatrixModelImpl();
        matrixModel1.setState(new PositionState("8:2,10:4,38:2"));
        assertEquals(matrixModel, matrixModel1);
    }
}