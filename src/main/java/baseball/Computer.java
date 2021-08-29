package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Computer {

    private Integer answer;
    private Balls answerBalls;

    public Integer getAnswer() {
        return answer;
    }

    public Balls getAnswerBalls() {
        return answerBalls;
    }

    public void generateAnswer() {
        int result = 0;
        List<Integer> candidates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(candidates);
        for (int i = 2 ; i >= 0; i --) {
            result += candidates.get(i) * Math.pow(10, i);
        }
        this.answer = result;

        setAnswerBalls();
    }

    private void setAnswerBalls() {
        List<Integer> ballNums = new ArrayList<>();

        int target = this.answer;
        for(int i = 0; i < 3; i ++) {
            ballNums.add(target % 10);
            target = target / 10;
        }

        this.answerBalls = new Balls(ballNums);
    }

}
