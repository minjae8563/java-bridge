package bridge.Controller;

import bridge.model.DownMap;
import bridge.model.UppMap;
import bridge.randomNumber.BridgeRandomNumberGenerator;
import bridge.service.BridgeMaker;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeSizeInputController bridgeSizeInputController = new BridgeSizeInputController();
    GameCommandInputController gameCommandInputController = new GameCommandInputController();
    MovingInputController movingInputController = new MovingInputController();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    OutputView outputView = new OutputView();

    DownMap downMap = new DownMap();
    UppMap uppMap = new UppMap();

    List<String> bridge = makeBridge();
    int idx = 0;
    int count = 1;

    public String move() {
        return movingInputController.inputUntilValidate();
    }

    public boolean retry() {
        String command = gameCommandInputController.inputGameCommandUntilValidate();
        return command.equals("R");
    }

    public List<String> makeBridge() {
        return bridgeMaker.makeBridge(bridgeSizeInputController.inputSizeUntilValidate());
    }

    public void bridgeGameStart() {
        boolean result = true;
        while (!isGameComplete()) {
            String moveForward = move();
            if (canMove(moveForward)) {
                continue;
            }
            if (!handleFailure(moveForward)) {
                result = false;
                break;
            }
        }
        printOutput(result);
    }

    private boolean isGameComplete() {
        return idx == bridge.size();
    }

    private boolean canMove(String moveForward) {
        return canGoUp(moveForward) || canGoDown(moveForward);
    }

    private boolean handleFailure(String moveForward) {
        if (moveForward.equals("U")) {
            canNotMoveUp();

        } else {
            canNotMoveDown();
        }
        if (!retry()) {
            return false;
        }
        resetMapAndRestart();
        return true;
    }

    private void printOutput(boolean result) {
        System.out.println("총 시도한 횟수: " + count);
        outputView.printResult(uppMap.getJoinUpMap(), downMap.getJoinDownMap(), result);
    }

    private boolean canGoDown(String moveForward) {
        if (moveForward.equals("D") && bridge.get(idx).equals("D")) {
            canMoveDown();
            return true;
        }
        return false;
    }

    private boolean canGoUp(String moveForward) {
        if (moveForward.equals("U") && bridge.get(idx).equals("U")) {
            canMoveUp();
            return true;
        }
        return false;
    }

    private void resetMapAndRestart() {
        idx = 0;
        count++;
        uppMap.clearUpMapLast();
        downMap.clearDownMapLast();
    }

    private void canNotMoveDown() {
        downMap.addDownMapX();
        uppMap.addUpMapSpace();
        printCurrentMap();
    }

    private void canMoveDown() {
        downMap.addDownMapO();
        uppMap.addUpMapSpace();
        printCurrentMap();
        idx++;
    }

    private void canNotMoveUp() {
        uppMap.addUpMapX();
        downMap.addDownMapSpace();
        printCurrentMap();
    }

    private void canMoveUp() {
        uppMap.addUpMapO();
        downMap.addDownMapSpace();
        printCurrentMap();
        idx++;
    }

    private void printCurrentMap() {
        outputView.printMap(uppMap.getJoinUpMap());
        outputView.printMap(downMap.getJoinDownMap());
    }
}
