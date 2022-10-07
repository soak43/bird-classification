package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class WaterfowlTest {
    private Waterfowl W1;
    private Waterfowl W2;
    private Waterfowl W3;

    @Before
    public void setupWaterfowl() {
        W1 = new Waterfowl();
        W2 = new Waterfowl("ducks");
        W3 = new Waterfowl("swans",Arrays.asList("They live near water sources") , 2, false, Arrays.asList("lake", "reservoir", "pond", "river"), Set.of("fish","aquatic invertebrates","insects"));
    }

    @Test
    public void testFirstConstructor(){
        assertEquals(Bird.Type.WATERFOWL,W1.getType());
        assertEquals(null,W1.getName());
        assertEquals(0,W1.getNumOfWings());
        assertEquals(Arrays.asList(), W1.getCharacteristic());
        assertEquals(Set.of(), W1.getFood());
        assertEquals(false,W1.isExtinct());
        assertEquals(Arrays.asList(),W1.getWaterBodies());
    }

    @Test
    public void testSecondConstructor(){
        assertEquals(Bird.Type.WATERFOWL,W2.getType());
        assertEquals("ducks",W2.getName());
        assertEquals(2,W2.getNumOfWings());
        assertEquals(Arrays.asList("They live near water sources"), W2.getCharacteristic());
        assertEquals(Set.of("fish","aquatic invertebrates","insects"), W2.getFood());
        assertEquals(false,W2.isExtinct());
        assertEquals(Arrays.asList("lake", "reservoir", "pond", "river"),W2.getWaterBodies());
    }


    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase1(){
        W2 = new Waterfowl("sparrow");
    }

    @Test
    public void testThirdConstructor(){
        assertEquals(Bird.Type.WATERFOWL,W3.getType());
        assertEquals("swans",W3.getName());
        assertEquals(2,W3.getNumOfWings());
        assertEquals(Arrays.asList("They live near water sources"), W3.getCharacteristic());
        assertEquals(Set.of("fish","aquatic invertebrates","insects"), W3.getFood());
        assertEquals(false,W3.isExtinct());
        assertEquals(Arrays.asList("lake", "reservoir", "pond", "river"),W3.getWaterBodies());
    }

    @Test
    public void setWaterBodies() {
        W1.setWaterBodies(Arrays.asList("ocean","sea"));
        assertEquals(Arrays.asList("ocean","sea"),W1.getWaterBodies());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase2(){
        W1.setWaterBodies(Arrays.asList("fountain"));
    }

    @Test
    public void getWaterBodies() {
        assertEquals(Arrays.asList("lake", "reservoir", "pond", "river"),W3.getWaterBodies());
    }

    @Test
    public void swim() {
        assertEquals("Race me",W1.swim());
    }

}