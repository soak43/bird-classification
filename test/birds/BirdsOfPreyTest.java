package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BirdsOfPreyTest {

    private BirdsOfPrey BoP;
    private BirdsOfPrey BoP1;
    private BirdsOfPrey hawk;


    @Before
    public void setup(){

        hawk = new BirdsOfPrey("hawks", Arrays.asList("They have sharp, hooked beaks with visible nostrils."), false, 2, Arrays.asList("small mammals", "other birds"));
    }

    @Test
    public void testConstructor1(){
        BoP = new BirdsOfPrey();
        assertEquals(Bird.Type.BIRDS_OF_PREY, BoP.getType());
    }

    @Test
    public void testConstructor2(){
        BoP1 = new BirdsOfPrey("eagles");
        assertEquals(2,BoP1.getNumOfWings());
        assertEquals(Bird.Type.BIRDS_OF_PREY, BoP1.getType());
        assertEquals(Arrays.asList("They have sharp, hooked beaks with visible nostrils."), BoP1.getCharacteristic());
        assertEquals(Arrays.asList("small mammals","insects"), BoP1.getFood());
    }

    @Test
    public void testOspreyFood(){
        BoP1 = new BirdsOfPrey("osprey");
        assertEquals(Arrays.asList("small mammals", "other birds"), BoP1.getFood());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase1(){
        BoP1 = new BirdsOfPrey("crow");
    }

    @Test
    public void hunt() {
        BoP = new BirdsOfPrey();
        assertEquals("The bird is hunting", BoP.Hunt("Rat"));
    }
}