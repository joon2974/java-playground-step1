package study.before;

import main.before.BaseballGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void setup() {
        baseballGame = new BaseballGame();
    }

    @DisplayName("정답 생성 테스트")
    @Test
    void test_generateAnswer() {
        // given
        String answer = baseballGame.generateAnswer();

        // when
        // then
        assertThat(answer.length()).isEqualTo(3);
        System.out.println(answer);
    }

    @DisplayName("유저 input 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123:123", "234:234", "132:132"}, delimiter = ':')
    void test_getUserInput(String userInput, String userInputCheck) {
        // given
        baseballGame.initView();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        String input = baseballGame.getUserInput();

        // then
        assertThat(input).isEqualTo(userInputCheck);
    }

    @DisplayName("문자열 비교 함수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:5:1", "1:3:0", "4:2:0"}, delimiter = ':')
    void test_isSame(String a, String b, String result) {
        // given
        Integer isSame = baseballGame.isSame(a, b);

        // when
        // then
        assertThat(isSame.toString()).isEqualTo(result);
    }

    @DisplayName("스트라이크 갯수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123:328:1", "123:124:2", "123:123:3", "123:456:0"}, delimiter = ':')
    void test_getStrikes(String input, String answer, String result) {
        // given
        Integer strikes = baseballGame.getStrikes(input, answer);

        // when
        // then
        assertThat(strikes.toString()).isEqualTo(result);
    }

    @DisplayName("문자열 포함 함수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:123:1", "3:152:0"}, delimiter = ':')
    void test_isContain(String input, String answer, String result) {
        // given
        Integer isContain = baseballGame.isContain(input, answer);

        // when
        // then
        assertThat(isContain.toString()).isEqualTo(result);
    }

    @DisplayName("볼 갯수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123:231:3" ,"123:321:2", "123:713:1", "123:987:0"}, delimiter = ':')
    void test_getBalls(String input, String answer, String result){
        // given
        Integer balls = baseballGame.getBalls(input, answer);

        // when
        // then
        assertThat(balls.toString()).isEqualTo(result);
    }

    @DisplayName("결과 안내 문자열 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:0:3볼", "0:2:2스트라이크", "1:1:1볼 1스트라이크", "0:3:3스트라이크", "0:0:낫씽"}, delimiter = ':')
    void test_getResultString(String balls, String strikes, String result) {
        // given
        Integer ballCnt = Integer.parseInt(balls);
        Integer strikeCnt = Integer.parseInt(strikes);

        // when
        String resultString = baseballGame.getResultString(ballCnt, strikeCnt);

        // then
        assertThat(resultString).isEqualTo(result);
    }
}
