package org.asupi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OutputSwitchMatrix {
    List<Switch> matrix = new ArrayList<Switch>();

    public OutputSwitchMatrix() {
        for (int i=0;i<36;i++){
            matrix.add(new Switch(i+29,1));
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
}
