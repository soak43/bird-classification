package environment;

import birds.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class AviaryTest {

    @Test
    public void AviaryBaseConstructorTestValid() {
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
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        Map<String,Integer> test = new HashMap<String,Integer>();
        test.put("nuts",2);
        test.put("seeds",2);
        test.put("fish",2);
        test.put("vegetation",2);
        test.put("berries",2);
        test.put("insects",2);
        test.put("small mammals",2);

        assertEquals("Anshul's Aviary",aviary.getName());
        assertEquals(Arrays.asList(myParrot,o2),aviary.getBirdList());
        assertEquals(new HashSet<Bird.Type>(Arrays.asList(Bird.Type.PARROT,Bird.Type.OWL)),aviary.getBirdTypeSet());
        assertEquals(test,aviary.getAviaryFoodStore());
        assertEquals("Kochi",aviary.getLocation());
//        assertEquals();
    }

    @Test
    public void setName() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        Map<String,Integer> test = new HashMap<String,Integer>();
        test.put("nuts",2);
        test.put("seeds",2);
        test.put("fish",2);
        test.put("vegetation",2);
        test.put("berries",2);
        test.put("insects",2);
        test.put("small mammals",2);

        aviary.setName("Sayli's Aviary");

        assertEquals("Sayli's Aviary",aviary.getName());
        assertEquals(Arrays.asList(myParrot,o2),aviary.getBirdList());
        assertEquals(new HashSet<Bird.Type>(Arrays.asList(Bird.Type.PARROT,Bird.Type.OWL)),aviary.getBirdTypeSet());
        assertEquals(test,aviary.getAviaryFoodStore());
        assertEquals("Kochi",aviary.getLocation());


    }
    @Test(expected = IllegalArgumentException.class)
    public void setNameInvalid() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("","Kochi", Arrays.asList(myParrot,o2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameInvalid2() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary(null,"Kochi", Arrays.asList(myParrot,o2));
    }

    @Test
    public void getBirdList() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        Map<String,Integer> test = new HashMap<String,Integer>();
        test.put("nuts",2);
        test.put("seeds",2);
        test.put("fish",2);
        test.put("vegetation",2);
        test.put("berries",2);
        test.put("insects",2);
        test.put("small mammals",2);

        ;

        assertEquals("Anshul's Aviary",aviary.getName());
        assertEquals(Arrays.asList(myParrot,o2),aviary.getBirdList());
        assertEquals(new HashSet<Bird.Type>(Arrays.asList(Bird.Type.PARROT,Bird.Type.OWL)),aviary.getBirdTypeSet());
        assertEquals(test,aviary.getAviaryFoodStore());
        assertEquals("Kochi",aviary.getLocation());

    }

    @Test
    public void getBirdTypeSet() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        Map<String,Integer> test = new HashMap<String,Integer>();
        test.put("nuts",2);
        test.put("seeds",2);
        test.put("fish",2);
        test.put("vegetation",2);
        test.put("berries",2);
        test.put("insects",2);
        test.put("small mammals",2);

        ;

        assertEquals("Anshul's Aviary",aviary.getName());
        assertEquals(Arrays.asList(myParrot,o2),aviary.getBirdList());
        assertEquals(new HashSet<Bird.Type>(Arrays.asList(Bird.Type.PARROT,Bird.Type.OWL)),aviary.getBirdTypeSet());
        assertEquals(test,aviary.getAviaryFoodStore());
        assertEquals("Kochi",aviary.getLocation());
    }

    @Test
    public void getAviaryFoodStore() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        Map<String,Integer> test = new HashMap<String,Integer>();
        test.put("nuts",2);
        test.put("seeds",2);
        test.put("fish",2);
        test.put("vegetation",2);
        test.put("berries",2);
        test.put("insects",2);
        test.put("small mammals",2);

        ;

        assertEquals("Anshul's Aviary",aviary.getName());
        assertEquals(Arrays.asList(myParrot,o2),aviary.getBirdList());
        assertEquals(new HashSet<Bird.Type>(Arrays.asList(Bird.Type.PARROT,Bird.Type.OWL)),aviary.getBirdTypeSet());
        assertEquals(test,aviary.getAviaryFoodStore());
        assertEquals("Kochi",aviary.getLocation());
    }

    @Test
    public void getLocation() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        Map<String,Integer> test = new HashMap<String,Integer>();
        test.put("nuts",2);
        test.put("seeds",2);
        test.put("fish",2);
        test.put("vegetation",2);
        test.put("berries",2);
        test.put("insects",2);
        test.put("small mammals",2);

        ;

        assertEquals("Anshul's Aviary",aviary.getName());
        assertEquals(Arrays.asList(myParrot,o2),aviary.getBirdList());
        assertEquals(new HashSet<Bird.Type>(Arrays.asList(Bird.Type.PARROT,Bird.Type.OWL)),aviary.getBirdTypeSet());
        assertEquals(test,aviary.getAviaryFoodStore());
        assertEquals("Kochi",aviary.getLocation());
    }

    @Test
    public void setLocation() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        Map<String,Integer> test = new HashMap<String,Integer>();
        test.put("nuts",2);
        test.put("seeds",2);
        test.put("fish",2);
        test.put("vegetation",2);
        test.put("berries",2);
        test.put("insects",2);
        test.put("small mammals",2);

        aviary.setName("Sayli's Aviary");

        assertEquals("Sayli's Aviary",aviary.getName());
        assertEquals(Arrays.asList(myParrot,o2),aviary.getBirdList());
        assertEquals(new HashSet<Bird.Type>(Arrays.asList(Bird.Type.PARROT,Bird.Type.OWL)),aviary.getBirdTypeSet());
        assertEquals(test,aviary.getAviaryFoodStore());
        assertEquals("Kochi",aviary.getLocation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLocationInvalid() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary",null, Arrays.asList(myParrot,o2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLocationInvalid2() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","", Arrays.asList(myParrot,o2));
    }
    @Test
    public void aviaryInfo() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));
        String testVal = "The Anshul's Aviary has the following birds that reside here as follows. \n" +
                "The Bird's name is sulfur-crested cockatoo. Some of the interesting characteristics of this bird are as follows \n" +
                "[They have a short, curved beak and are known for their intelligence and ability to mimic sounds.]\n" +
                "The Bird's name is Owl. Some of the interesting characteristics of this bird are as follows \n" +
                "[They are distinguished by the facial disks that frame the eyes and bill.]";
        assertEquals(testVal,aviary.Info());
    }
    @Test
    public void aviaryInfoElseCase() {

        Aviary aviary = new Aviary("Anshul's Aviary","Kochi");
        String testVal = "The Anshul's Aviary has no birds as of now";
        assertEquals(testVal,aviary.Info());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addBirdNullCase() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        List<Bird> b = new ArrayList<>();
        b.add(myParrot);
        b.add(o2);
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", b);

        aviary.addBird((Bird)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addBirdOverloadedInvalidlCase1() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        aviary.addBird((List<Bird>)null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addBirdOverloadedInvalidCase2() {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));

        aviary.addBird(new ArrayList<Bird>());
    }
    @Test
    public void addBirdOverloadedCase(){
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
        Owl o3 = new Owl();
        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));
        Pigeon pigeon = new Pigeon();



        aviary.addBird(Arrays.asList(pigeon,o3));

//        {fruits=2, nuts=2, seeds=4, fish=4, vegetation=4, berries=4, insects=4, small mammals=4}

        Map<String,Integer> test = new HashMap<String,Integer>();
        test.put("nuts",2);
        test.put("seeds",4);
        test.put("fish",4);
        test.put("vegetation",4);
        test.put("berries",4);
        test.put("insects",4);
        test.put("small mammals",4);
        test.put("fruits",2);

        assertEquals("Anshul's Aviary",aviary.getName());
        assertEquals(Arrays.asList(myParrot,o2,pigeon,o3),aviary.getBirdList());
        assertEquals(new HashSet<Bird.Type>(Arrays.asList(Bird.Type.PARROT,Bird.Type.OWL,Bird.Type.PIGEON)),aviary.getBirdTypeSet());
        assertEquals(test,aviary.getAviaryFoodStore());
        assertEquals("Kochi",aviary.getLocation());

    }


    @Test(expected = IllegalStateException.class)
    public void addBirdOverflowBOP() {
        List<Bird> myBirds = new ArrayList<>();
        for(int i = 0 ; i <  5; i ++){
            myBirds.add(new BirdsOfPrey());
        }

        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", myBirds);

        aviary.addBird(new BirdsOfPrey());

    }

    @Test(expected = IllegalStateException.class)
    public void addBirdOverflowFB() {
        List<Bird> myBirds = new ArrayList<>();
        for(int i = 0 ; i <  6; i ++){
            myBirds.add(new FlightlessBirds());
        }

        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", myBirds);

        aviary.addBird(new FlightlessBirds());

    }

    @Test
    public void addBirdOverflowWF() {
        List<Bird> myBirds = new ArrayList<>();
        for(int i = 0 ; i <  3; i ++){
            myBirds.add(new Waterfowl());
        }

        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", myBirds);

        aviary.addBird(new Waterfowl());

    }

//    @Test(expected = IllegalArgumentException.class)
    @Test(expected = IllegalArgumentException.class)
    public void addDiffType() {
        List<Bird> myBirds = new ArrayList<>();
        for(int i = 0 ; i <  3; i ++){
            myBirds.add(new Pigeon());
        }

        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", myBirds);

        aviary.addBird(new Waterfowl());

    }
}