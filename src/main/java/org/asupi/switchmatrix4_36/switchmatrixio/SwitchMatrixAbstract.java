package org.asupi.switchmatrix4_36.switchmatrixio;

import org.asupi.switchmatrix4_36.PositionState;
import org.asupi.switchmatrix4_36.Switch;

import java.util.Map;

public abstract class SwitchMatrixAbstract implements SwitchMatrix {
    int absolute_start;
    Map<Integer, Switch> matrix;

    @Override
    public Map<Integer, Switch> getMatrix() {
        return matrix;
    }

    @Override
    public void setPosition(int switchNumber, int position) {
        matrix.get(switchNumber).setPosition(position);
    }

    @Override
    public Integer getPosition(int switchNumber) {
        Switch item;
        if ((item = matrix.get(switchNumber)) != null)
            return item.getPosition();
        else
            return -1;
    }

    @Override
    public void changeState(PositionState positionState) {
        Map<Integer, Integer> state = positionState.getState();
        for (Integer key : state.keySet()) {
            matrix.get(key).setPosition(state.get(key));
        }
    }
}
