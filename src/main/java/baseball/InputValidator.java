package baseball;

import com.sun.jdi.request.InvalidRequestStateException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int MAX_LENGTH_NUM = 999;
    private static final int MIN_LENGTH_NUM = 100;

    private InputValidator() {
    }

    public static void validate(Integer input) {
        validateLength(input);
        validateDuplicate(input);
        for (int i = 0; i < 3; i ++) {
            int target = input % 10;
            validateEach(target);
            input = input / 10;
        }
    }

    public static void validateEach(Integer input) {
        if (input < MIN_VALUE || input > MAX_VALUE)
            throw new InvalidRequestStateException("0 ~ 9 사이의 값을 입력하세요.");
    }

    public static void validateLength(Integer input) {
        if (input > MAX_LENGTH_NUM || input < MIN_LENGTH_NUM)
            throw new InvalidRequestStateException("3자리 숫자만 입력하세요.");
    }

    public static void validateDuplicate(Integer input) {
        String[] inputString = input.toString().split("");
        Set inputSet = new HashSet(Arrays.asList(inputString));
        if (inputSet.size() != 3) throw new InvalidRequestStateException("중복 번호가 있습니다.");
    }
}
