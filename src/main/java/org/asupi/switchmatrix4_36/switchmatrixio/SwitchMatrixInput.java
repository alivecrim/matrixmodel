package org.asupi.switchmatrix4_36.switchmatrixio;

import org.asupi.switchmatrix4_36.Switch;

import java.util.HashMap;

public class SwitchMatrixInput extends SwitchMatrixAbstract {


    public SwitchMatrixInput(Integer numStart) {
        matrix = new HashMap<>();
        absolute_start = numStart;
        for (int i = 0; i < 7; i++) {
            matrix.put(i, new Switch(i + numStart, 0));
        }
    }
}
