package main;

public class Ladder {

    private int bottom;
    private int top;

    public Ladder(int bottom, int top) {
        this.bottom = bottom;
        this.top = top;
    }

    boolean isPresentAtPosition(int position) {
        return bottom == position;
    }

    int top() {
        return top;
    }

    int bottom() {
        return bottom;
    }
}
