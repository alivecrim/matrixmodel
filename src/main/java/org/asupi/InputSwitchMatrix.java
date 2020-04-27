package org.asupi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InputSwitchMatrix {
    private int absolute_start;
    private List<Switch> matrix = new ArrayList<>();

    public int getAbsolute_start() {
        return absolute_start;
    }

    public InputSwitchMatrix(Integer numStart) {
        absolute_start=numStart;
        for (int i=0;i<7;i++){
            matrix.add(new Switch(i+numStart,1));
        }
    }

    public List<Switch> getMatrix() {
        return matrix;
    }


    public void setPosition(int switchNumber, int position) {
        matrix.get(switchNumber).setPosition(position);
    }

    public Integer getPosition(int switchNumber) {
        return matrix.get(switchNumber).getPosition();
    }

    public void changeState(PositionState positionState) {
        Map<Integer,Integer> state = positionState.getState();
        for (Integer key:
                state.keySet()) {
            matrix.get(key).setPosition(state.get(key));
        }
    }
}
