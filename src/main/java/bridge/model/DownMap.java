package bridge.model;

import java.util.ArrayList;

public class DownMap {
    ArrayList<String> downMap = new ArrayList<>();

    public DownMap(){
    }

    public void addDownMapO() {
        downMap.add("O");
    }

    public void addDownMapX() {
        downMap.add("X");
    }

    public void addDownMapSpace() {
        downMap.add(" ");
    }

    public void clearDownMapLast() {
        downMap = new ArrayList<>();
    }

    public String getJoinDownMap() {
        return String.join(" | ",downMap);
    }
}
