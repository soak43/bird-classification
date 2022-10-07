package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FlightlessBirdsTest {

    private FlightlessBirds FB1;

    @Before
    public void setup(){
        FB1 = new FlightlessBirds("emu", Arrays.asList("They live on the ground"), 2, false,Arrays.asList("seeds", "fruits"));
    }

    @Test
    public void testConstructor1(){
        FB1 = new FlightlessBirds();
        assertEquals(Bird.Type.FLIGHTLESS_BIRDS, FB1.getType());
    }

    @Test
    public void testConstructor2(){
        FB1 = new FlightlessBirds("emu");
        assertEquals(0,FB1.getNumOfWings());
        assertEquals(Bird.Type.FLIGHTLESS_BIRDS, FB1.getType());
        assertEquals(Arrays.asList("They live on the ground"), FB1.getCharacteristic());
        assertEquals(Arrays.asList("seeds", "fruits"), FB1.getFood());
    }

    @Test
    public void testKiwiFood(){
        FB1 = new FlightlessBirds("kiwi");
        assertEquals(Arrays.asList("buds", "berries", "seeds"), FB1.getFood());
    }

    @Test
    public void testIsExtinct(){
        FB1 = new FlightlessBirds("moa");
        assertEquals(true,FB1.isExtinct());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase1(){
        FB1 = new FlightlessBirds("crow");
    }


    @Test(expected = IllegalArgumentException.class)
    public void fly() {
        FB1 = new FlightlessBirds("kiwi");
        FB1.fly();
    }
}