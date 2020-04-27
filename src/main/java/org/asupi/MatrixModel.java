package org.asupi;

import java.util.ArrayList;
import java.util.List;

public class MatrixModel {
    OutputSwitchMatrix outPutSwitchMatrix;
    List<InputSwitchMatrix> inputSwitchMatrices;

    public MatrixModel() {
        inputSwitchMatrices = new ArrayList<>();
        outPutSwitchMatrix = new OutputSwitchMatrix();
        inputSwitchMatrices.add(new InputSwitchMatrix(8));
        inputSwitchMatrices.add(new InputSwitchMatrix(1));
        inputSwitchMatrices.add(new InputSwitchMatrix(15));
        inputSwitchMatrices.add(new InputSwitchMatrix(22));
    }

    public void setPosition(int inputPort, int outputPort) {
        int tmp = (int)Math.ceil(outputPort/6.0);
        outPutSwitchMatrix.getMatrix().get(outputPort+28).setPosition(inputPort);
        List <Switch> l = inputSwitchMatrices.get(inputPort-1).getMatrix();
        Switch s = l.get(0);
        s.setPosition(tmp);
        int pos = outputPort - ((tmp-1)*6);
        l.get(tmp).setPosition(pos);
    }

    public Integer getOut(int i) {
        for (Switch itemOut : outPutSwitchMatrix.getMatrix().values()) {
            if (itemOut.getPosition() == i) {
                InputSwitchMatrix input = inputSwitchMatrices.get(i-1);
                Switch firstLayerSwitch = input.getMatrix().get(0);
                Integer firstLayer = firstLayerSwitch.getPosition();
                Switch secondLayerSwitch = input.getMatrix().get(firstLayer);
                Integer secondLayer = secondLayerSwitch.getPosition();

                int s2 = itemOut.getNumber() - 28;
                if (((secondLayerSwitch.getNumber() - 2) * 6 + secondLayer) == itemOut.getNumber() - 28)
                    return itemOut.getNumber() - 28;
            }
        }

        return -1;
    }
}
