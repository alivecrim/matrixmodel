package org.asupi.switchmatrix4_36;

import java.util.HashMap;
import java.util.Map;

public class PositionState {
    private Map<Integer,Integer> state;
    private String stateString;
    public PositionState() {
        state=new HashMap<>();
    }

    @Override
    public String toString() {
        return stateString;
    }

    public PositionState(String state){
        this();
        setState(state);
        stateString=state;
    }
    public void setState(String s) {
        String[] self = s.split(",");
        for (String item:
             self) {
            String[] kv = item.split(":");
            state.put(Integer.parseInt(kv[0]),Integer.parseInt(kv[1]));
        }
    }

    public Map<Integer,Integer> getState() {
        return state;
    }
}
