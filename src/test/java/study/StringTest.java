package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_1() {
        String values [] = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void split_2() {
        String[] value = "1".split(",");
        assertThat(value).containsExactly("1");
    }

    @Test
    void substring() {
        String sub = "(1,2)".substring(1, 4);
        assertThat(sub).isEqualTo("1,2");
    }

    @DisplayName("charAt 메소드와 그 예외에 대한 테스트 학습")
    @Test
    void charAt() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char result = "abc".charAt(5);
                })
                .withMessageContaining("range: ");
    }
}
