package main;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ladders {

    private ArrayList<Ladder> ladders = new ArrayList<>();

    public Ladders(int count) {
        ladders.ensureCapacity(count);
    }

   public boolean isPresent(int position) {
        return ladders.stream()
                .filter(ladder -> ladder.isPresentAtPosition(position))
                .count() > 0;
    }

    public int top(int position) {
        return ladders.stream()
                .filter(ladder -> ladder.isPresentAtPosition(position))
                .collect(Collectors.toList()).get(0).top();
    }

    public void add(Ladder ladder) throws InvalidLadderException {
        if(isPresent(ladder.bottom()))
            throw new InvalidLadderException();
        ladders.add(ladder);
    }
}
