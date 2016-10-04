package test;

import main.InvalidLadderException;
import main.Ladder;
import main.Ladders;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LaddersTest {

    private Ladders ladders ;

    @Test
    public void Check_If_Ladder_Present_At_GivenPosition()
    {
        assertEquals(true,ladders.isPresent(8));
    }

    @Before
    public void Setup() throws InvalidLadderException {
        ladders = new Ladders(1);
        ladders.add(new Ladder(8,20));
    }

    @Test
    public void GetTopOfLadder_AtGivenPosition()
    {
        assertEquals(20,ladders.top(8));
    }

    @Test(expected = InvalidLadderException.class)
    public void Should_Throw_Exception_If_Two_LadderPresent_AtSamePosition() throws InvalidLadderException {

        ladders = new Ladders(2);
        ladders.add(new Ladder(8,20));
        ladders.add(new Ladder(8,20));
    }
}
