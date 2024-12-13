package bridge.Controller;

import bridge.view.InputView;

public class BridgeSizeInputController {
    InputView inputView = new InputView();
    public int inputSizeUntilValidate() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputSizeUntilValidate();
        }
    }
}
