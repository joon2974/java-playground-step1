package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameTest {

    @DisplayName("3스트라이크인 경우 경기가 끝남을 알린다.")
    @Test
    void test_finish() {
        // given
        Game game = new Game();
        List<Judge> judges = new ArrayList<>(Arrays.asList(Judge.STRIKE, Judge.STRIKE, Judge.STRIKE));

        // when
        boolean result = game.isFinished(judges);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("3스트라이크가 아닌 경우 경기가 끝나지 않음을 알린다.")
    @Test
    void test_not_finish() {
        // given
        Game game = new Game();
        List<Judge> judges = new ArrayList<>(Arrays.asList(Judge.STRIKE, Judge.STRIKE, Judge.BALL));

        // when
        boolean result = game.isFinished(judges);

        // then
        Assertions.assertThat(result).isFalse();
    }

    @DisplayName("3스트라이크인 경우 3 스트라이크를 반환한다.")
    @Test
    void test_announce() {
        // given
        Game game = new Game();
        List<Judge> judges = new ArrayList<>(Arrays.asList(Judge.STRIKE, Judge.STRIKE, Judge.STRIKE));

        // when
        String result = game.announce(judges);

        // then
        Assertions.assertThat(result).isEqualTo("3스트라이크 ");
    }

    @DisplayName("2스트라이크 1볼인 경우 2스트라이크 1볼 반환한다.")
    @Test
    void test_announce2() {
        // given
        Game game = new Game();
        List<Judge> judges = new ArrayList<>(Arrays.asList(Judge.STRIKE, Judge.BALL, Judge.STRIKE));

        // when
        String result = game.announce(judges);

        // then
        Assertions.assertThat(result).isEqualTo("2스트라이크 1볼");
    }

    @DisplayName("3볼인 경우 3볼 반환한다.")
    @Test
    void test_announce3() {
        // given
        Game game = new Game();
        List<Judge> judges = new ArrayList<>(Arrays.asList(Judge.BALL, Judge.BALL, Judge.BALL));

        // when
        String result = game.announce(judges);

        // then
        Assertions.assertThat(result).isEqualTo("3볼");
    }

    @DisplayName("낫씽 반")
    @Test
    void test_announce4() {
        // given
        Game game = new Game();
        List<Judge> judges = new ArrayList<>(Arrays.asList(Judge.NOTHING, Judge.NOTHING, Judge.NOTHING));

        // when
        String result = game.announce(judges);

        // then
        Assertions.assertThat(result).isEqualTo("낫씽");
    }
}
