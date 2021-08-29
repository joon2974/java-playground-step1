package baseball;

public class Ball {

    private int index;
    private int number;

    public Ball(int index, int number) {
        this.index = index;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return index == ball.index &&
                number == ball.number;
    }

    public int getIndex() {
        return this.index;
    }

    public int getNumber() {
        return this.number;
    }

    public Judge play(Ball ball) {
        if (this.equals(ball)) return Judge.STRIKE;
        if (this.number == ball.getNumber()) return Judge.BALL;
        return Judge.NOTHING;
    }

}
