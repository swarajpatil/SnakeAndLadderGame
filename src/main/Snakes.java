package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Snakes extends ArrayList<Snake> {

    private List<Snake> snakes;
    public Snakes(int count) {
        snakes = new ArrayList<>(count);
    }

    public boolean isPresent(int position) {
        return stream()
                .filter(snake -> snake.isPresentAtPosition(position))
                .count() > 0;
    }

    public int tail(int position) {
        return stream()
                .filter(snake -> snake.isPresentAtPosition(position))
                .collect(Collectors.toList()).get(0).tail();
    }
}
