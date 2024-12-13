package bridge.Controller;

import bridge.view.InputView;

public class MovingInputController {
    InputView inputView = new InputView();
    public String inputUntilValidate() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputUntilValidate();
        }
    }
}
