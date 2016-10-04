package main;

import java.util.*;

public class Game {

    private static final int START_POSITION = 1;
    private Map<String, Integer> players = new HashMap();
    private String currentPlayer;
    private Ladders ladders;
    private int currentNumberOnDice;
    private Snakes snakes;
    private GameMode gameMode;
    private int boardSize;

    public Game(List<String> players, GameMode gameMode, int boardSize) {
        this.gameMode = gameMode;
        this.boardSize = boardSize;
        initializePlayerPosition(players);
        addSnakesAndLaddersToBoard();
    }

    private void addSnakesAndLaddersToBoard() {
        ladders = gameMode.ladders();
        snakes = gameMode.snakes();
    }

    private void initializePlayerPosition(List<String> players) {
        for (String player : players) {
            this.players.putIfAbsent(player, START_POSITION);
        }
        currentPlayer = players.get(0);
    }

    public void move(int number) throws InvalidNumberOnDice {
        if(number > 6) throw new InvalidNumberOnDice();
        players.replace(currentPlayer, moveToPosition(number));
        changeCurrentPlayer();
    }

    private void changeCurrentPlayer() {
        currentPlayer = getNextPlayer();
    }

    private String getNextPlayer() {
        Iterator<String> playerkeys = players.keySet().iterator();
        while (playerkeys.hasNext()) {
            if (playerkeys.next().equals(currentPlayer) && playerkeys.hasNext()) {
                return playerkeys.next();
            }
        }
        return players.keySet().iterator().next();
    }

    public int spinDice() {
        currentNumberOnDice = new Random().nextInt(6);
        return currentNumberOnDice;
    }

    private int moveToPosition(int numberOnDice) {
        if (ladders.isPresent(positionBasedNumberOnDice(numberOnDice)))
            return ladders.top(positionBasedNumberOnDice(numberOnDice));
        if (snakes.isPresent(positionBasedNumberOnDice(numberOnDice)))
            return snakes.tail(positionBasedNumberOnDice(numberOnDice));
        else
            return positionBasedNumberOnDice(numberOnDice);
    }

    private int positionBasedNumberOnDice(int numberOnDice) {
        return players.get(currentPlayer) + numberOnDice;
    }

    public int getPlayerPosition(String player) {
        return players.get(player);
    }

    public int getCurrentDiceNumber() {
        return currentNumberOnDice;
    }

    public int totalLadder() {
        return 5;
    }
}
