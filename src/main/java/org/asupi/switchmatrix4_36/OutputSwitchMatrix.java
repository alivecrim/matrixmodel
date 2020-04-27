package org.asupi.switchmatrix4_36;

import java.util.HashMap;
import java.util.Map;

public class OutputSwitchMatrix {
    private Map<Integer, Switch> matrix;
    private int absolute_start = 29;

    public OutputSwitchMatrix() {
        matrix = new HashMap<>();
        for (int i = absolute_start; i < absolute_start + 36; i++) {
            matrix.put(i, new Switch(i, 0));
        }
    }

    public Map<Integer, Switch> getMatrix() {
        return matrix;
    }


    public void setPosition(int switchNumber, int position) {
        Switch item;
        if ((item = matrix.get(switchNumber)) != null)
            item.setPosition(position);
    }

    public Integer getPosition(int switchNumber) {
        Switch item;
        if ((item = matrix.get(switchNumber)) != null)
            return item.getPosition();
        else
            return -1;
    }

    public void changeState(PositionState positionState) {
        Map<Integer, Integer> state = positionState.getState();
        for (Integer key : state.keySet()) {
            matrix.get(key).setPosition(state.get(key));
        }
    }
}
