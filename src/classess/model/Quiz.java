package classess.model;

public class Quiz {
    private int qNum = 0;
    private int score = 0;

    private int[][] q = new int[][]{{3, 1, 4, 1, 5}, {1, 1, 2, 3, 5}, {1, 4, 9, 16, 25}, {2, 3, 5, 7, 11}, {1, 2, 4, 8, 16}};
    private int[] a = new int[]{9, 8, 36, 13, 32};

    public int[] getA() {
        return a;
    }

    public int[] getQ(int row) {
        return q[row];
    }

    public int getQNum() {
        return qNum;
    }

    public int getScore() {
        return score;
    }

    public void incScore(int score) {
        this.score += score;
    }

    public void incQNum() {
        this.qNum++;
    }
}
