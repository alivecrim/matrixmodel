package org.asupi.switchmatrix4_36;

import java.util.*;

public class MatrixModelImpl implements MatrixModel {
    private OutputSwitchMatrix outPutSwitchMatrix;
    private List<InputSwitchMatrix> inputSwitchMatrices;
    private Map<Integer, Switch> fullSwitchList;

    public MatrixModelImpl() {
        inputSwitchMatrices = new ArrayList<>();
        outPutSwitchMatrix = new OutputSwitchMatrix();
        inputSwitchMatrices.add(new InputSwitchMatrix(8));
        inputSwitchMatrices.add(new InputSwitchMatrix(1));
        inputSwitchMatrices.add(new InputSwitchMatrix(15));
        inputSwitchMatrices.add(new InputSwitchMatrix(22));

        fullSwitchList = new HashMap<>();
        fullSwitchList.putAll(outPutSwitchMatrix.getMatrix());
        inputSwitchMatrices.forEach((inputSwitchMatrix) -> inputSwitchMatrix.getMatrix().forEach((sw) -> {
            fullSwitchList.put(sw.getNumber(), sw);
        }));

    }

    @Override
    public Map<Integer, Switch> getSwitchList() {
        return fullSwitchList;
    }

    @Override
    public List<Switch> compareMatrix(MatrixModel model) {
        List<Switch> diff = new ArrayList<>();
        model.getSwitchList().forEach((k, sw) -> {
            if (!this.fullSwitchList.get(k).equals(sw)) {
                diff.add(sw);
            }
        });
        return diff;
    }

    @Override
    public void setPosition(int inputPort, int outputPort) {
        int tmp = (int) Math.ceil(outputPort / 6.0);
        int outPosition = getOutPosition(inputPort);
        outPutSwitchMatrix.getMatrix().get(outputPort + 28).setPosition(outPosition);
        List<Switch> l = inputSwitchMatrices.get(inputPort - 1).getMatrix();
        Switch s = l.get(0);
        s.setPosition(tmp);
        int pos = outputPort - ((tmp - 1) * 6);
        l.get(tmp).setPosition(pos);
    }
@Override
    public Integer getPosition(int i) {
        InputSwitchMatrix input = inputSwitchMatrices.get(i - 1);
        Switch firstLayerSwitch = input.getMatrix().get(0);
        Integer firstLayerSwitchPosition = firstLayerSwitch.getPosition();
        Switch secondLayerSwitch = input.getMatrix().get(firstLayerSwitchPosition);
        Integer secondLayerSwitchPosition = secondLayerSwitch.getPosition();

        for (Switch itemOut : outPutSwitchMatrix.getMatrix().values()) {
            if (itemOut.getPosition() == getOutPosition(i)) {
                if (calcPort(secondLayerSwitch) == itemOut.getNumber() - 28)
                    return itemOut.getNumber() - 28;
            }
        }
        return -1;
    }

    private int calcPort(Switch sw) {
        HashMap<Integer, Integer> ps = new HashMap<>();
        ps.put(2, 0);
        ps.put(3, 6);
        ps.put(4, 12);
        ps.put(5, 18);
        ps.put(6, 14);
        ps.put(7, 30);

        ps.put(9, 0);
        ps.put(10, 6);
        ps.put(11, 12);
        ps.put(12, 18);
        ps.put(13, 14);
        ps.put(14, 30);

        ps.put(16, 0);
        ps.put(17, 6);
        ps.put(18, 12);
        ps.put(19, 18);
        ps.put(20, 14);
        ps.put(21, 30);

        ps.put(23, 0);
        ps.put(24, 6);
        ps.put(25, 12);
        ps.put(26, 18);
        ps.put(27, 14);
        ps.put(28, 30);

        return ps.get(sw.getNumber()) + sw.getPosition();
    }

    private int getOutPosition(int inputPort) {
        int outPosition;
        switch (inputPort) {
            case 1:
                outPosition = 2;
                break;
            case 2:
                outPosition = 1;
                break;
            case 3:
                outPosition = 3;
                break;
            case 4:
                outPosition = 4;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + inputPort);
        }
        return outPosition;
    }

    @Override
    public void setState(PositionState positionState) {
        Map<Integer, Integer> state = positionState.getState();
        for (Integer key :
                state.keySet()) {
            fullSwitchList.get(key).setPosition(state.get(key));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixModelImpl that = (MatrixModelImpl) o;
        return Objects.equals(fullSwitchList, that.fullSwitchList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullSwitchList);
    }

    @Override
    public PositionState getState() {
        StringBuilder stateString = new StringBuilder();
        fullSwitchList.forEach((k, v) -> stateString.append(String.format("%d:%d,", k, v.getPosition())));
        return new PositionState(stateString.toString());
    }
}
