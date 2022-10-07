package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class BirdTest {

    private Bird b;
    private Bird b2;

    @Before
    public void setupBird(){
        b = new BirdsOfPrey();
        b2 = new BirdsOfPrey("eagles");
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase1(){
        b.setFood(Set.of("beans","berries"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase2(){
        b.setName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase3(){
        b.setNumOfWings(3);
    }

    @Test
    public void flyTest(){
        assertEquals("Flap flap",b.fly());
    }

    @Test
    public void eatTest(){
        assertEquals("The bird is eating",b.eat(Set.of("berries","fish")));
    }

    @Test
    public void chirpTest(){
        assertEquals("chirp chirp",b.chirp());
    }

    @Test
    public void drinkTest(){
        assertEquals("The bird is drinking",b.drink());
    }

    @Test
    public void toStringTest(){
        assertEquals("Bird{" +
                ", type='" + Bird.Type.BIRDS_OF_PREY + '\'' +
                ", characteristic='" + "[They have sharp, hooked beaks with visible nostrils.]" + '\'' +
                ", extinct=" + "false" +
                ", numOfWings=" + "2" +
                ", favoriteFoods=" + Set.of("small mammals", "insects") +
                '}',b2.toString());
    }

    @Test
    public void getCharTest(){
        b.setCharacteristic(Arrays.asList("They have sharp, hooked beaks with visible nostrils.","They have sharp claws"));
        assertEquals("They have sharp, hooked beaks with visible nostrils.. They have sharp claws.",b.displayCharacteristics());
    }

}