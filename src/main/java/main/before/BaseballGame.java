package main.before;

import java.util.*;

public class BaseballGame {

    private InputView inputView;
    private OutputView outputView;

    public BaseballGame() {}

    public void start() {
        initView();
        int isContinue = 1;

        while(isContinue != 2) {
            String answer = generateAnswer();
            startGame(answer);
            isContinue = getUserContinue();
        }
    }

    public void initView() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public String generateAnswer() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(numbers);

        String ans = "";
        for (int i = 0; i < 3; i ++) {
            ans += numbers.get(i);
        }
        return ans;
    }

    public void startGame(String answer) {
        int strikes = 0;
        int balls = 0;

        while(!(strikes == 3 && balls == 0)) {
            String input = getUserInput();

            strikes = getStrikes(input, answer);
            balls = getBalls(input, answer);

            outputView.showAnnounce(getResultString(balls, strikes));
        }
        outputView.showAnnounce("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String getUserInput() {
        return inputView.getUserInputLine("숫자를 입력해 주세요: ");
    }

    public Integer getStrikes(String input, String answer) {
        int strikeCnt = 0;
        String [] inputList = input.split("");
        String [] answerList = answer.split("");

        for (int i = 0; i < 3; i ++) {
            strikeCnt += isSame(inputList[i], answerList[i]);
        }

        return strikeCnt;
    }

    public Integer isSame(String input, String answer) {
        if (input.equals(answer)) return 1;
        return 0;
    }

    public Integer getBalls(String input, String answer) {
        int ballCnt = 0;
        String [] inputList = input.split("");
        String [] answerList = answer.split("");

        for (int i = 0; i < 3; i ++) {
            ballCnt += isContain(inputList[i], answer) - isSame(inputList[i], answerList[i]);
        }

        return ballCnt;
    }

    public Integer isContain(String input, String answer) {
        if (answer.contains(input)) return 1;
        return 0;
    }

    public String getResultString (Integer balls, Integer strikes) {
        String result = "";
        if (balls != 0) result += balls + "볼";
        if (strikes != 0) result += addBlankIfBeforeExist(result) + strikes + "스트라이크";
        if (result.length() == 0) return "낫씽";
        return result;
    }

    public String addBlankIfBeforeExist(String beforeString) {
        if (beforeString.length() == 0) return beforeString;
        return " ";
    }

    public Integer getUserContinue() {
        return inputView.getUserInputInteger("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
