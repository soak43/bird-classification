package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BirdsOfPreyTest {

    private BirdsOfPrey BoP;
    private BirdsOfPrey BoP1;
    private BirdsOfPrey hawk;


    @Before
    public void setup(){
        hawk = new BirdsOfPrey("hawks", Arrays.asList("They have sharp, hooked beaks with visible nostrils."), false, 2, Set.of("small mammals", "other birds"));
    }

    @Test
    public void testConstructor1(){
        BoP = new BirdsOfPrey();
        assertEquals(null,BoP.getName());
        assertEquals(Bird.Type.BIRDS_OF_PREY, BoP.getType());
        assertEquals(0,BoP.getNumOfWings());
        assertEquals(Arrays.asList(), BoP.getCharacteristic());
        assertEquals(Set.of(), BoP.getFood());
        assertEquals(false,BoP.isExtinct());
    }

    @Test
    public void testConstructor2(){
        BoP1 = new BirdsOfPrey("eagles");
        assertEquals("eagles",BoP1.getName());
        assertEquals(2,BoP1.getNumOfWings());
        assertEquals(Bird.Type.BIRDS_OF_PREY, BoP1.getType());
        assertEquals(Arrays.asList("They have sharp, hooked beaks with visible nostrils."), BoP1.getCharacteristic());
        assertEquals(Set.of("small mammals","insects"), BoP1.getFood());
        assertEquals(false,BoP1.isExtinct());
    }

    @Test
    public void testOspreyFood(){
        BoP1 = new BirdsOfPrey("osprey");
        assertEquals("osprey",BoP1.getName());
        assertEquals(2,BoP1.getNumOfWings());
        assertEquals(Bird.Type.BIRDS_OF_PREY, BoP1.getType());
        assertEquals(Arrays.asList("They have sharp, hooked beaks with visible nostrils."), BoP1.getCharacteristic());
        assertEquals(Set.of("small mammals", "other birds"), BoP1.getFood());
        assertEquals(false,BoP1.isExtinct());
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