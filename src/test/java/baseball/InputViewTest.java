package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class InputViewTest {

    @DisplayName("사용자의 입력을 scanner를 통해 받는다.")
    @ParameterizedTest
    @CsvSource(value = {"123:123", "234:234"}, delimiter = ':')
    void inputTest(String userInput, String userInputCheck) {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when
        String result = InputView.getStringUserInput("string 입력");

        // then
        Assertions.assertThat(result).isEqualTo(userInputCheck);
    }
}
