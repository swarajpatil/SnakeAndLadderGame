package main;

public class Snake {
    private int mouth;
    private int tail;

    public Snake(int mouth, int tail) {
        this.mouth = mouth;
        this.tail = tail;
    }

    boolean isPresentAtPosition(int position) {
        return position == mouth;
    }

    int tail() {
        return tail;
    }
}
