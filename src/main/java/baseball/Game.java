package baseball;

import java.util.List;

public class Game {

    private static final String STRIKE = "스트라이크 ";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫씽";

    private Computer computer;

    public Game() {
        this.computer = new Computer();
    }

    public void play() {
        boolean isNotFinish = true;

        while(isNotFinish) {
            playOnce();
            String continueUserInput = InputView.getStringUserInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            isNotFinish = isContinue(continueUserInput);
        }
    }

    private void playOnce() {
        this.computer.generateAnswer();
        boolean isNotFinished = true;

        while (isNotFinished) {
            Integer userInput = InputView.getIntegerUserInput("숫자를 입력해 주세요: ");
            Balls userBalls = new Balls(userInput);

            OutputView.showOutputAnnounce(announce(this.computer.play(userBalls)));
            isNotFinished = !isFinished(this.computer.play(userBalls));
        }

        OutputView.showOutputAnnounce("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
    }

    public String announce(List<Judge> judges) {
        String result = "";

        int strikeCnt = getJudgeCnt(judges, Judge.STRIKE);
        if (strikeCnt > 0) result += strikeCnt + STRIKE;

        int ballCnt = getJudgeCnt(judges, Judge.BALL);
        if (ballCnt > 0) result += ballCnt + BALL;

        if (result.length() > 0) return result;

        return NOTHING;
    }

    public boolean isFinished(List<Judge> judges) {
        return getJudgeCnt(judges, Judge.STRIKE) == 3;
    }

    public boolean isContinue(String userContinue) {
        return !userContinue.equals("2");
    }

    private int getJudgeCnt(List<Judge> judges, Judge targetJudge) {
        return (int) judges.stream().filter(judge -> judge.equals(targetJudge)).count();
    }
}
