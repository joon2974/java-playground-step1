package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> ballNums) {
       init(ballNums);
    }

    private void init(List<Integer> ballNums) {
        List<Ball> tmpBalls = new ArrayList<>();

        for (int i = 0; i < ballNums.size(); i ++) {
            tmpBalls.add(new Ball(i, ballNums.get(i)));
        }

        this.balls = tmpBalls;
    }

    public Judge play(Ball userBall) {
        if (getJudgeCount(Judge.STRIKE, userBall) > 0) return Judge.STRIKE;

        if (getJudgeCount(Judge.BALL, userBall) > 0) return Judge.BALL;

        return Judge.NOTHING;
    }

    private Long getJudgeCount(Judge targetJudge, Ball userBall) {
        return balls.stream()
                .map(ball -> ball.play(userBall))
                .filter(judge -> judge.equals(targetJudge))
                .count();
    }
}
