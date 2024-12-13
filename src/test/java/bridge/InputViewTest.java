package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


import bridge.view.InputView;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView = new InputView();

    @Test
    void 다리_길이_입력_테스트() {
        assertThatThrownBy(() -> inputView.isNumberBetween3And20(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이동하는_칸_입력_테스트() {
        assertThatThrownBy(() -> inputView.isStringUOrD("P"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_테스트() {
        assertThatThrownBy(() -> inputView.isStringROrQ("P"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}