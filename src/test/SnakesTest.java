package test;

import main.Snake;
import main.Snakes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakesTest {

    private  Snakes snakes;

    @Before
    public void setup() {
        snakes = new Snakes(1);
        snakes.add(new Snake(45,5));
    }

    @Test
    public void CheckIfSnakePresentAtGivenPosition() throws Exception {
        assertEquals(true,snakes.isPresent(45));
    }

    @Test
    public void GetTailOfSnakePresentAtGivenPosition() throws Exception {
        assertEquals(5,snakes.tail(45));
    }
}