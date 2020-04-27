package org.asupi.switchmatrix4_36;

import java.util.List;
import java.util.Map;

public interface MatrixModel {
    Map<Integer, Switch> getSwitchList();

    List<Switch> compareMatrix(MatrixModel model);

    void setPosition(int inputPort, int outputPort);

    Integer getPosition(int i);

    void setState(PositionState positionState);

    PositionState getState();
}
