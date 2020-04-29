package org.asupi.switchmatrix4_36.switchmatrixio;

import org.asupi.switchmatrix4_36.PositionState;
import org.asupi.switchmatrix4_36.Switch;

import java.util.Map;

public interface SwitchMatrix {
    Map<Integer, Switch> getMatrix();

    void setPosition(int switchNumber, int position);

    Integer getPosition(int switchNumber);

    void changeState(PositionState positionState);
}
