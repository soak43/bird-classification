package environment;

import birds.Bird;
import birds.Owl;
import birds.Parrot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ConservatoryTest {

    Set<Aviary> aviarySet;
    Aviary aviary1;
    Parrot myParrot;
    Owl o2;
    Aviary aviary2;
    Map<String,Integer> testValFood;
    Conservatory conservatory;

    @Before
    public void Conservatory() {
        aviary1 = new Aviary("Anshul's Aviary", "Kochi");
        myParrot = new Parrot("sulfur-crested cockatoo");
        o2 = new Owl();
        aviary2 = new Aviary("Sayali's Aviary", "Kochi", Arrays.asList(myParrot, o2));
        aviarySet = new HashSet<>();
        aviarySet.addAll(Arrays.asList(aviary1, aviary2));
        testValFood = new HashMap<>();
        conservatory = new Conservatory(aviarySet);
        System.out.println(conservatory.getAviarySet());

        testValFood.put("nuts",2);
        testValFood.put("seeds",2);
        testValFood.put("fish",2);
        testValFood.put("vegetation",2);
        testValFood.put("berries",2);
        testValFood.put("small mammals",2);
        testValFood.put("insects",2);


    }

    @Test
    public void getAviarySet() {
        assertEquals(aviarySet, conservatory.getAviarySet());
        assertEquals(testValFood,conservatory.getConservatoryFoodReq());
    }

    @Test
    public void getConservatoryFoodReq() {
        assertEquals(aviarySet, conservatory.getAviarySet());
        assertEquals(testValFood,conservatory.getConservatoryFoodReq());
    }

    @Test( expected = IllegalArgumentException.class)
    public void addAviaryInvalid1() {

        conservatory.addAviary("","kochi");
    }

    @Test( expected = IllegalArgumentException.class)
    public void addAviaryInvalid2() {

        conservatory.addAviary("Anshul's Aviary","");
    }
    @Test
    public void addAviaryPlain() {
        Set<Aviary> aviaries = new HashSet<>();
        Aviary aviary1add = new Aviary("Sayali's Aviary","pune");
        aviaries.add(aviary1add);
        Conservatory conservatory2 = new Conservatory(aviaries);

        Aviary aviary2add = new Aviary("Anshul's Aviary","Kochi");
        conservatory2.addAviary(aviary2add);

        assertEquals(aviaries, conservatory2.getAviarySet());
//        assertEquals(,conservatory.getConservatoryFoodReq());
    }
    @Test
    public void addAviaryUsingNameLocationBird() {
        Set<Aviary> aviaries = new HashSet<>();
        Aviary aviary1add = new Aviary("Sayali's Aviary","pune");
        aviaries.add(aviary1add);
        Conservatory conservatory2 = new Conservatory(aviaries);
        Owl owl = new Owl();


        conservatory2.addAviary("Sayali's Aviary","Pune",owl);

        assertEquals(aviaries, conservatory2.getAviarySet());
//        assertEquals(,conservatory.getConservatoryFoodReq());
    }


    @Test
    public void sortedAlphabetically() {
    }

    @Test
    public void testSortedAlphabetically() {
    }

    @Test
    public void getAviaryListForBird() {
    }

    @Test
    public void getFoodReq() {
    }

    @Test
    public void aviaryLocBirdInfo() {
    }

    @Test
    public void getAviaryInfo() {
    }

    @Test
    public void testGetAviarySet() {
    }

    @Test
    public void testGetConservatoryFoodReq() {
    }

    @Test
    public void testAddAviary1() {
    }

    @Test
    public void testAddAviary2() {
    }

    @Test
    public void testAddAviary3() {
    }

    @Test
    public void testAddAviary4() {
    }

    @Test
    public void testAddAviary5() {
    }

    @Test
    public void addBirdToConservatory() {
    }

    @Test
    public void testSortedAlphabetically1() {
    }

    @Test
    public void testSortedAlphabetically2() {
    }

    @Test
    public void testGetAviaryListForBird() {
    }

    @Test
    public void calcConservatoryFoodReq() {
    }

    @Test
    public void testAviaryLocBirdInfo() {
    }

    @Test
    public void testGetAviaryInfo() {
    }
}