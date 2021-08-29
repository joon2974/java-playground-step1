package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @DisplayName("컴퓨터는 3자리의 랜덤 수로 이루어진 정답을 생성한다.")
    @Test
    void test_generateAnswer() {
        // given
        Computer computer = new Computer();
        computer.generateAnswer();

        // when
        // then
        InputValidator.validate(computer.getAnswer());
    }
}
