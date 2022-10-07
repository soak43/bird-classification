package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class ShoreBirdTest {

    private ShoreBird SB1;
    private ShoreBird SB2;
    private ShoreBird SB3;

    @Before
    public void setupShoreBird(){
        SB1 = new ShoreBird();
        SB3 = new ShoreBird("horned puffin", Arrays.asList("They live near water sources"),2 , false, Arrays.asList("sea","ocean"), Set.of("fish","aquatic invertebrates","insects"));
    }

    @Test
    public void testFirstConstructor(){
        assertEquals(Bird.Type.SHOREBIRD,SB1.getType());
        assertEquals(null,SB1.getName());
        assertEquals(0,SB1.getNumOfWings());
        assertEquals(Arrays.asList(), SB1.getCharacteristic());
        assertEquals(Set.of(), SB1.getFood());
        assertEquals(false,SB1.isExtinct());
        assertEquals(Arrays.asList(),SB1.getWaterBodies());
    }

    @Test
    public void testGreatAuk(){
        SB2 = new ShoreBird("great auk");
        assertEquals(Bird.Type.SHOREBIRD,SB2.getType());
        assertEquals("great auk",SB2.getName());
        assertEquals(2,SB2.getNumOfWings());
        assertEquals(Arrays.asList("They live near water sources"), SB2.getCharacteristic());
        assertEquals(Set.of("fish","aquatic invertebrates","insects"), SB2.getFood());
        assertEquals(true,SB2.isExtinct());
        assertEquals(Arrays.asList("ocean"),SB2.getWaterBodies());
    }

    @Test
    public void testHornedPuffin(){
        SB2 = new ShoreBird("horned puffin");
        assertEquals(Bird.Type.SHOREBIRD,SB2.getType());
        assertEquals("horned puffin",SB2.getName());
        assertEquals(2,SB2.getNumOfWings());
        assertEquals(Arrays.asList("They live near water sources"), SB2.getCharacteristic());
        assertEquals(Set.of("fish","aquatic invertebrates","insects"), SB2.getFood());
        assertEquals(false,SB2.isExtinct());
        assertEquals(Arrays.asList("sea","ocean"),SB2.getWaterBodies());
    }

    @Test
    public void testAfricanJacana(){
        SB2 = new ShoreBird("african jacana");
        assertEquals(Bird.Type.SHOREBIRD,SB2.getType());
        assertEquals("african jacana",SB2.getName());
        assertEquals(2,SB2.getNumOfWings());
        assertEquals(Arrays.asList("They live near water sources"), SB2.getCharacteristic());
        assertEquals(Set.of("fish","aquatic invertebrates","insects"), SB2.getFood());
        assertEquals(false,SB2.isExtinct());
        assertEquals(Arrays.asList("wetland"),SB2.getWaterBodies());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase1(){
        SB2 = new ShoreBird("duck");
    }

    @Test
    public void testThirdConstructor(){
        assertEquals(Bird.Type.SHOREBIRD,SB3.getType());
        assertEquals("horned puffin",SB3.getName());
        assertEquals(2,SB3.getNumOfWings());
        assertEquals(Arrays.asList("They live near water sources"), SB3.getCharacteristic());
        assertEquals(Set.of("fish","aquatic invertebrates","insects"), SB3.getFood());
        assertEquals(false,SB3.isExtinct());
        assertEquals(Arrays.asList("sea","ocean"),SB3.getWaterBodies());
    }

    @Test
    public void setWaterBodies() {
        SB1.setWaterBodies(Arrays.asList("ocean","sea"));
        assertEquals(Arrays.asList("ocean","sea"),SB1.getWaterBodies());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase2(){
        SB1.setWaterBodies(Arrays.asList("fountain"));
    }

    @Test
    public void getWaterBodies() {
        assertEquals(Arrays.asList("sea","ocean"),SB3.getWaterBodies());
    }

    @Test
    public void swim() {
        assertEquals("Splish splash!",SB1.swim());
    }

}