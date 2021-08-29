package baseball;

import com.sun.jdi.request.InvalidRequestStateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {

    @DisplayName("0 이하의 숫자를 입력하면 에러를 반환한다.")
    @Test
    void test_under_zero() {
        // given
        Integer zero = 0;
        Integer ten = 10;

        // when
        // then
        assertThrows(InvalidRequestStateException.class, () -> InputValidator.validateEach(zero));
        assertThrows(InvalidRequestStateException.class, () -> InputValidator.validateEach(ten));
    }

    @DisplayName("입력받은 숫자가 3자리 초과이면 에러를 반환한다.")
    @Test
    void test_over_999() {
        // given
        Integer over = 1000;

        // when
        // then
        assertThrows(InvalidRequestStateException.class, () -> InputValidator.validateLength(over));
    }

    @DisplayName("입력받은 숫자 중 중복 숫자가 있으면 에러를 반환한다.")
    @Test
    void test_duplicate() {
        // given
        Integer input = 122;

        // when
        // then
        assertThrows(InvalidRequestStateException.class, () -> InputValidator.validateDuplicate(input));
    }

    @DisplayName("입력받은 숫자 전체에 대해 검증")
    @Test
    void test_whole() {
        // given
        Integer input = 123;

        // when
        // then
        InputValidator.validate(input);
    }
}
