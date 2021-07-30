package study;

import main.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void prepare() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("계산기 테스트")
    @Test
    void sample() {
        String input = "1 + 3 * 4 / 2";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Double result = stringCalculator.calculate();

        assertThat(result).isEqualTo(8.0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 3 * 4 / 2:8.0", "2 + 3 * 4 / 2:10.0", "3 - 2 + 11 / 2 * 3:18.0"}, delimiter = ':')
    void calculatorTest(String input, String expected) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Double result = stringCalculator.calculate();

        assertThat(result).isEqualTo(Double.parseDouble(expected));
    }
}
