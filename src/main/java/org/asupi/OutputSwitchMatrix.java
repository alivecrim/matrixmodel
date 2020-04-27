package org.asupi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputSwitchMatrix {
    private Map<Integer, Switch> matrix = new HashMap();

    public OutputSwitchMatrix() {
        for (int i = 29; i < 29 + 36; i++) {
            matrix.put(i, new Switch(i, 1));
        }
    }

    public Map<Integer, Switch> getMatrix() {
        return matrix;
    }


    public void setPosition(int switchNumber, int position) {
        Switch item;
        if ((item=matrix.get(switchNumber))!=null)
            item.setPosition(position);
    }

    public Integer getPosition(int switchNumber) {
        Switch item;
        if ((item=matrix.get(switchNumber))!=null)
            return item.getPosition();
        else
            return -1;
    }

    public void changeState(PositionState positionState) {
        Map<Integer, Integer> state = positionState.getState();
        for (Integer key :
                state.keySet()) {
            matrix.get(key).setPosition(state.get(key));
        }
    }
}
