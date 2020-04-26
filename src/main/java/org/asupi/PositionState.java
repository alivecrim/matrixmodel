package org.asupi;

import java.util.HashMap;
import java.util.Map;

public class PositionState {
    private Map<Integer,Integer> state;
    public PositionState() {
        state=new HashMap<>();
    }

    public PositionState(String state){
        this();
        setState(state);
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
