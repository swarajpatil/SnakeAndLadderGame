package test;

import main.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private static final int START_POSITION = 1;
    private List<String> players;
    private Game game;

    @Before
    public void Setup()
    {
        players = new ArrayList<>();
        players.add("John");
        players.add("Smith");
        game = new Game(players,GameMode.Easy,10);
    }

    @Test
    public void WhenGameStart_PlayerShouldBeAtInitialPosition()
    {
        assertEquals(START_POSITION,game.getPlayerPosition("John"));
        assertEquals(START_POSITION,game.getPlayerPosition("Smith"));
    }

    @Test
    public void WhenPlayerPlay_PlayerPositionShouldChange() throws InvalidNumberOnDice
    {
        game.move(game.spinDice());
        int expectedValue = game.getCurrentDiceNumber() + START_POSITION;
        assertEquals(expectedValue,game.getPlayerPosition("John"));
    }

    @Test
    public void WhenSecondPlayerPlay_SecondPlayerPositionShouldChange() throws InvalidNumberOnDice
    {
        game.move(game.spinDice());
        game.move(game.spinDice());
        int expectedValue = game.getCurrentDiceNumber() + START_POSITION;
        assertEquals(expectedValue,game.getPlayerPosition("Smith"));
    }

    @Test
    public void WhenFirstPlayerPlayAgain_PositionShouldChange() throws InvalidNumberOnDice
    {
        game.move(5);
        game.move(game.spinDice());
        game.move(4);
        assertEquals(10,game.getPlayerPosition("John"));
    }

    @Test
    public void PlayerShouldMoveToTopOfLadder_WhenLadderPresentOnChangedPosition() throws InvalidNumberOnDice
    {
        game.move(2);
        game.move(game.spinDice());
        game.move(5);
        assertEquals(20,game.getPlayerPosition("John"));
    }

    @Test
    public void PlayerShouldMoveToTailOfSnake_WhenSnakePresentOnChangedPosition() throws InvalidNumberOnDice
    {
        game.move(6);
        game.move(game.spinDice());
        game.move(6);
        game.move(game.spinDice());
        game.move(6);
        game.move(6);
        game.move(5);
        game.move(2);
        game.move(6);
        assertEquals(5,game.getPlayerPosition("John"));
    }
}
