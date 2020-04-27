package org.asupi;

import java.util.List;

public class MatrixModel {
    OutputSwitchMatrix outPutSwitchMatrix;
    List<InputSwitchMatrix> inputSwitchMatrices;

    public MatrixModel() {

        outPutSwitchMatrix = new OutputSwitchMatrix();
    }
    public void setPosition(int inputPort, int outputPort) {


    }

    public Object getOut(int i) {

        return 5;
    }
}
