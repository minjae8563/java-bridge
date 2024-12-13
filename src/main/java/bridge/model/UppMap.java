package bridge.model;

import static org.mockito.internal.util.StringUtil.join;

import java.util.ArrayList;

public class UppMap {
    ArrayList<String> upMap = new ArrayList<>();

    public UppMap(){
    }

    public void addUpMapO() {
        upMap.add("O");
    }

    public void addUpMapX() {
        upMap.add("X");
    }

    public void addUpMapSpace() {
        upMap.add(" ");
    }

    public void clearUpMapLast() {
        upMap = new ArrayList<>();
    }

    public String getJoinUpMap() {
        return String.join(" | ", upMap);
    }
}
