package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class FlightlessBirdsTest {

    private FlightlessBirds FB1;

    @Before
    public void setup(){
        FB1 = new FlightlessBirds("emu", Arrays.asList("They live on the ground"), 2, false,Set.of("seeds", "fruits"));
    }

    @Test
    public void testConstructor1(){
        FB1 = new FlightlessBirds();
        assertEquals(Bird.Type.FLIGHTLESS_BIRDS, FB1.getType());
        assertEquals(null,FB1.getName());
        assertEquals(0,FB1.getNumOfWings());
        assertEquals(Arrays.asList(), FB1.getCharacteristic());
        assertEquals(Set.of(), FB1.getFood());
        assertEquals(false,FB1.isExtinct());
    }

    @Test
    public void testConstructor2(){
        FB1 = new FlightlessBirds("emu");
        assertEquals("emu",FB1.getName());
        assertEquals(0,FB1.getNumOfWings());
        assertEquals(Bird.Type.FLIGHTLESS_BIRDS, FB1.getType());
        assertEquals(Arrays.asList("They live on the ground"), FB1.getCharacteristic());
        assertEquals(Set.of("seeds", "fruits"), FB1.getFood());
        assertEquals(false,FB1.isExtinct());
    }

    @Test
    public void testKiwiFood(){
        FB1 = new FlightlessBirds("kiwi");
        assertEquals("kiwi",FB1.getName());
        assertEquals(0,FB1.getNumOfWings());
        assertEquals(Bird.Type.FLIGHTLESS_BIRDS, FB1.getType());
        assertEquals(Arrays.asList("They live on the ground"), FB1.getCharacteristic());
        assertEquals(Set.of("buds", "berries", "seeds"), FB1.getFood());
        assertEquals(false,FB1.isExtinct());
    }

    @Test
    public void testIsExtinct(){
        FB1 = new FlightlessBirds("moa");
        assertEquals("moa",FB1.getName());
        assertEquals(0,FB1.getNumOfWings());
        assertEquals(Bird.Type.FLIGHTLESS_BIRDS, FB1.getType());
        assertEquals(Arrays.asList("They live on the ground"), FB1.getCharacteristic());
        assertEquals(Set.of("seeds", "fruits"), FB1.getFood());
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