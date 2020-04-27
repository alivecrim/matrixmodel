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

    public Integer getOut(int i) {
        for (Switch item:
        outPutSwitchMatrix.getMatrix().values()) {
            if(item.getPosition() ==  i){
                return item.getNumber();
            }
        }

        return 5;
    }
}
