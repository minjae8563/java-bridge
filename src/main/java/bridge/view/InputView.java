package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import org.junit.platform.commons.util.StringUtils;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String userInput = Console.readLine();
        if (!userInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
        isNumberBetween3And20(Integer.parseInt(userInput));
        return Integer.parseInt(userInput);
    }

    public void isNumberBetween3And20(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String userInput = Console.readLine();
        isStringUOrD(userInput);
        return userInput;
    }

    public void isStringUOrD(String input) {
        String upOrDown = "U|D";
        if (!input.matches(upOrDown)) {
            throw new IllegalArgumentException("[ERROR] 입력은 U 또는 D를 입력해 주세요.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String userInput = Console.readLine();
        isStringROrQ(userInput);
        return userInput;
    }

    public void isStringROrQ(String input) {
        String retryOrQuick = "R|Q";
        if (!input.matches(retryOrQuick)) {
            throw new IllegalArgumentException("[ERROR] 입력은 R 또는 Q를 입력해 주세요.");
        }
    }
}
