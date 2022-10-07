package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class ParrotTest {

    private Parrot p1;
    private Parrot p2;
    private Parrot p3;

    @Before
    public void setupParrot(){
        p1 = new Parrot();
        p2 = new Parrot("sulfur-crested cockatoo");
        p3 = new Parrot("rose-ring parakeet", Arrays.asList("They have a short, curved beak and are known for their intelligence and ability to mimic sounds."),2, false, Set.of("vegetation", "berries", "nuts", "seeds"),10,"Good Morning");
    }

    @Test
    public void testFirstConstructor(){
        assertEquals(Bird.Type.PARROT,p1.getType());
        assertEquals(null,p1.getName());
        assertEquals(0,p1.getNumOfWings());
        assertEquals(Arrays.asList(), p1.getCharacteristic());
        assertEquals(Set.of(), p1.getFood());
        assertEquals(false,p1.isExtinct());
        assertEquals(0,p1.getNoOfWords());
        assertEquals(null,p1.getFavoriteSaying());
    }

    @Test
    public void testSecondConstructor(){
        assertEquals("sulfur-crested cockatoo",p2.getName());
        assertEquals(2,p2.getNumOfWings());
        assertEquals(Set.of("vegetation", "berries", "nuts","seeds"),p2.getFood());
        assertEquals(Arrays.asList("They have a short, curved beak and are known for their intelligence and ability to mimic sounds."),p2.getCharacteristic());
        assertEquals(Bird.Type.PARROT,p2.getType());
        assertEquals(false,p2.isExtinct());
        assertEquals(0,p2.getNoOfWords());
        assertEquals(null,p2.getFavoriteSaying());
    }

    public void testThirdConstructor(){
        assertEquals("rose-ring parakeet",p2.getName());
        assertEquals(2,p3.getNumOfWings());
        assertEquals(Arrays.asList("vegetation", "berries", "nuts","seeds"),p3.getFood());
        assertEquals(Arrays.asList("They have a short, curved beak and are known for their intelligence and ability to mimic sounds."),p3.getCharacteristic());
        assertEquals(Bird.Type.PARROT,p3.getType());
        assertEquals(false,p3.isExtinct());
        assertEquals(10,p3.getNoOfWords());
        assertEquals("Good Morning",p3.getFavoriteSaying());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase1(){
        p2 = new Parrot("blue parrot");
    }

    @Test
    public void getFavoriteSaying() {
        assertEquals("Good Morning",p3.getFavoriteSaying());
    }

    @Test
    public void setFavoriteSaying() {
        p3.setFavoriteSaying("Hello");
        assertEquals("Hello",p3.getFavoriteSaying());
    }

    @Test
    public void getNoOfWords() {
        assertEquals(10,p3.getNoOfWords());
    }

    @Test
    public void setNoOfWords() {
        p3.setNoOfWords(20);
        assertEquals(20,p3.getNoOfWords());
    }

    @Test
    public void speak() {
        assertEquals("The parrot is saying - Good Evening",p3.speak("Good Evening"));
    }
}