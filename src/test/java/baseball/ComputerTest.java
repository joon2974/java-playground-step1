package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @DisplayName("컴퓨터는 유저의 입력을 받아 Judge의 리스트를 반환한다.")
    @Test
    void test_computerJudge() {
        // given
        Computer computer = new Computer();
        computer.generateAnswer();
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));

        // when
        List<Judge> judges = computer.play(userBalls);

        // then
        Assertions.assertThat(judges.size()).isEqualTo(3);
    }
}
