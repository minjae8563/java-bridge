package bridge.Controller;

import bridge.view.InputView;

public class GameCommandInputController {
    InputView inputView = new InputView();

    public String inputGameCommandUntilValidate() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputGameCommandUntilValidate();
        }
    }
}
