package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {

    @DisplayName("주어진 두 볼의 위치, 숫자가 같으면 스트라이를 반환한다.")
    @Test
    void test_strike() {
        // given
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(1, 1);

        // when
        Judge judge = computerBall.play(userBall);

        // then
        assertThat(judge).isEqualTo(Judge.STRIKE);
    }

    @DisplayName("주어진 두 볼의 위치가 다르고 숫자가 같으면 볼을 반환한다.")
    @Test
    void test_ball() {
        // given
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(2, 1);

        // when
        Judge judge = computerBall.play(userBall);

        // then
        assertThat(judge).isEqualTo(Judge.BALL);
    }

    @DisplayName("주어진 두 볼의 숫자와 위치가 모두 다르면 낫씽을 반환한다.")
    @Test
    void test_nothing() {
        // given
        Ball computerBall = new Ball(1, 1);
        Ball userBall = new Ball(2, 3);

        // when
        Judge judge = computerBall.play(userBall);

        // then
        assertThat(judge).isEqualTo(Judge.NOTHING);
    }
}
