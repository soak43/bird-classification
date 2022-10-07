package environment;

import birds.Bird;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class AviaryTest {

    @Test
    public void AviaryBaseContructorTestValid() {
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi");
        assertEquals("Anshul's Aviary", aviary.getName());
        assertEquals("Kochi",aviary.getLocation());
        assertEquals(new ArrayList<>(),aviary.getBirdList());
        assertEquals(new HashSet<>(),aviary.getBirdTypeSet());
        assertEquals(new HashMap<String, Integer>(),aviary.getAviaryFoodStore());
    }

    @Test(expected = IllegalArgumentException.class)
    public void AviaryBaseContructorTestInvalid1() {
        Aviary aviary = new Aviary("","Kochi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void AviaryBaseContructorTestInvalid2() {
        Aviary aviary = new Aviary("Anshul","");
    }

    public void AviaryOverLoadedContructor1TestValid() {
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi");
        assertEquals("Anshul's Aviary", aviary.getName());
        assertEquals("Kochi",aviary.getLocation());
        assertEquals(new ArrayList<>(),aviary.getBirdList());
        assertEquals(new HashSet<>(),aviary.getBirdTypeSet());
        assertEquals(new HashMap<String, Integer>(),aviary.getAviaryFoodStore());
    }
    @Test(expected = IllegalArgumentException.class)
    public void AviaryOverLoadedContructor1TestInvalid1(){
        Aviary aviary = new Aviary("Anshul","Kochi",(Bird)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AviaryOverLoadedContructor1TestInvali2(){
        Aviary aviary = new Aviary("Anshul","Kochi",(List<Bird>)null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void AviaryOverLoadedContructor1TestInvali3(){
        Aviary aviary = new Aviary("Anshul","Kochi",new ArrayList<Bird>());
    }



    @Test
    public void getName() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void getBirdList() {
    }

    @Test
    public void getBirdTypeSet() {
    }

    @Test
    public void getAviaryFoodStore() {
    }

    @Test
    public void getLocation() {
    }

    @Test
    public void setLocation() {
    }

    @Test
    public void aviaryInfo() {
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi",new Bird());
    }

    @Test
    public void addBird() {
    }

    @Test
    public void testAddBird() {
    }
}