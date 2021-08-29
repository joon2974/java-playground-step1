package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BallsTest {

    @DisplayName("위치와 숫자가 모두 같으면 스트라이크를 반환한다.")
    @Test
    void test_strike() {
        // given
        Balls balls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Ball ball = new Ball(0, 1);

        // when
        Judge judge = balls.play(ball);

        // then
        Assertions.assertThat(judge).isEqualTo(Judge.STRIKE);
    }

    @DisplayName("위치는 다르고 숫자가 같은 볼이 있으면 볼을 반환한다.")
    @Test
    void test_ball() {
        // given
        Balls balls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Ball ball = new Ball(1, 1);

        // when
        Judge judge = balls.play(ball);

        // then
        Assertions.assertThat(judge).isEqualTo(Judge.BALL);
    }

    @DisplayName("정답에 같은 숫자가 없으면 낫씽을 반환한다.")
    @Test
    void test_nothing() {
        // given
        Balls balls = new Balls(new ArrayList<>(Arrays.asList(1, 2, 3)));
        Ball ball = new Ball(1, 9);

        // when
        Judge judge = balls.play(ball);

        // then
        Assertions.assertThat(judge).isEqualTo(Judge.NOTHING);
    }
}
