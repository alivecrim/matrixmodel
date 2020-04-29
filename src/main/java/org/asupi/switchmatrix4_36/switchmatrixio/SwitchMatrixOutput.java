package org.asupi.switchmatrix4_36.switchmatrixio;

import org.asupi.switchmatrix4_36.Switch;

import java.util.HashMap;

public class SwitchMatrixOutput extends SwitchMatrixAbstract {

    public SwitchMatrixOutput() {
        absolute_start = 29;
        matrix = new HashMap<>();
        for (int i = absolute_start; i < absolute_start + 36; i++) {
            matrix.put(i, new Switch(i, 0));
        }
    }
}
