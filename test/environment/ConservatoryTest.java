package environment;

import birds.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.util.*;

import static org.junit.Assert.*;

public class ConservatoryTest {

    private Conservatory c;
    Owl o2 = new Owl();
    Owl o3 = new Owl();
    Pigeon p1 = new Pigeon();
    Pigeon p2 = new Pigeon();
    ShoreBird sb1 = new ShoreBird("great auk");
    ShoreBird sb2 = new ShoreBird();
    Waterfowl w1 = new Waterfowl();
    Waterfowl w2 = new Waterfowl("ducks");
    FlightlessBirds fb1 = new FlightlessBirds();
    FlightlessBirds fb2 = new FlightlessBirds("emu");
    BirdsOfPrey BoP1 = new BirdsOfPrey();
    BirdsOfPrey BoP2 = new BirdsOfPrey("eagles");
    Parrot myParrot = new Parrot("sulfur-crested cockatoo");
    private Aviary aviary1;
    private Aviary aviary2;

    @Before
    public void ConservatorySetup(){

        aviary1 = new Aviary("Aviary1","Kochi", Arrays.asList(myParrot,o2));
        aviary2 = new Aviary("Aviary2","Kochi", Arrays.asList(o3,p1,p2));
        Conservatory c2 = new Conservatory(Set.of(aviary1,aviary2));

    }

    @Test
    public void ConstructorTest1(){
        c = new Conservatory(Set.of(aviary1));
//        assertEquals(aviary1,c);
        Map<String,List<String>> test = new TreeMap<>();
        List<String> l = new ArrayList<>();
        l.add("Kochi");
        l.add("Kochi");
        test.put("Owl",l);
        test.put("sulfur-crested cockatoo",l);
        assertEquals(test,c.sortAlphabetically());
        Map<String,Integer> d = new HashMap<>();
        d.put("nuts",4);
        d.put("seeds",4);
        d.put("fish",4);
        d.put("vegetation",4);
        d.put("berries",4);
        d.put("small mammals",4);
        d.put("insects",4);
        assertEquals(d,c.getFoodReq());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgCase1(){
        Set<Aviary> aviarySet = new HashSet<Aviary>();
        for(int i=0 ; i < 21 ; i++){
            Aviary aviary = new Aviary("Aviary " + i,"Location",new Owl());
            aviarySet.add(aviary);
        }
        System.out.println(aviarySet.size());
        Conservatory c1 =  new Conservatory(aviarySet);

    }

    @Test(expected = IllegalStateException.class)
    public void addAviaryOverflow1(){
        Set<Aviary> aviarySet = new HashSet<Aviary>();
        for(int i=0 ; i < 20 ; i++){
            Aviary aviary = new Aviary("Aviary " + i,"Location",new Owl());
            aviarySet.add(aviary);
        }
        System.out.println(aviarySet.size());
        Conservatory c1 =  new Conservatory(aviarySet);
        c1.addAviary(new Aviary("Aviary " + 21,"Location",new Owl()));

    }

    @Test
    public void getAviarySet() {
        Set<Aviary> aviarySet = new HashSet<Aviary>();
        List<Aviary> aviaryList = new ArrayList<Aviary>();
        for(int i=0 ; i < 3 ; i++){
            Aviary aviary = new Aviary("Aviary " + i,"Location",new Owl());
            aviarySet.add(aviary);
            aviaryList.add(aviary);
        }
        Conservatory c15 =  new Conservatory(aviarySet);
        assertEquals(Set.of(aviaryList.get(0),aviaryList.get(1),aviaryList.get(2)),c15.getAviarySet());

    }

    @Test
    public void getAlphabeticalOrderDictionaryOfBirds() {
    }

    @Test
    public void getConservatoryFoodReq() {
    }

    @Test
    public void addAviary() {
        Owl o2 = new Owl();
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        List<Bird> birdList = new ArrayList<>();
        birdList.add(myParrot);
        birdList.add(o2);
        List<Bird> birdList2 = new ArrayList<>();
        birdList2.add(new Owl());
        birdList.add(new Pigeon());
        Aviary aviary1 = new Aviary("Aviary1","Kochi", birdList);
        Aviary aviary2 = new Aviary("Aviary2","Pune", birdList2);
        Set<Aviary> aviarySet = new HashSet<>();
        aviarySet.add(aviary1);
        Conservatory c = new Conservatory(aviarySet);
        assertEquals(aviary2,c.addAviary(aviary2));
    }

    @Test
    public void testAddAviary() {
        Owl o2 = new Owl();
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        List<Bird> birdList = new ArrayList<>();
        birdList.add(myParrot);
        birdList.add(o2);
        List<Bird> birdList2 = new ArrayList<>();
        birdList2.add(new Owl());
        birdList.add(new Pigeon());
        Aviary aviary1 = new Aviary("Aviary1","Kochi", birdList);
        Aviary test = new Aviary("Sayali's Aviary","Pune", birdList);
        Set<Aviary> aviarySet = new HashSet<>();
        aviarySet.add(aviary1);
        Conservatory c = new Conservatory(aviarySet);
        assertEquals(test.getName(),c.addAviary("Sayali's Aviary","Pune",birdList).getName());
        assertEquals(test.getLocation(),c.addAviary("Sayali's Aviary","Pune",birdList).getLocation());
        assertEquals(test.getBirdList(),c.addAviary("Sayali's Aviary","Pune",birdList).getBirdList());
    }

    @Test
    public void sortAlphabetically() {
        Aviary a1 = new Aviary("A1","Kochi",Arrays.asList(new Owl(),new Pigeon(),new Parrot("gray parrot")));
        Aviary a2 = new Aviary("A1","Kochi",Arrays.asList(new Owl(),new ShoreBird("horned puffin"),new Parrot("gray parrot")));
        Set<Aviary> aviarySetUse = new HashSet<>();
        aviarySetUse.addAll(Arrays.asList(a1,a2));
        Conservatory c10 = new Conservatory(aviarySetUse);
    }

    @Test
    public void getAviaryListForBird() {
//    create aviariies say 3 with owl
        Aviary a1 = new Aviary("A1","Kochi",Arrays.asList(new Owl(),new Pigeon(),new Parrot("gray parrot")));
        Aviary a2 = new Aviary("A1","Kochi",Arrays.asList(new Owl(),new ShoreBird("horned puffin"),new Parrot("gray parrot")));
        Set<Aviary> aviarySetUse = new HashSet<>();
        aviarySetUse.addAll(Arrays.asList(a1,a2));
        Conservatory c10 = new Conservatory(aviarySetUse);
        Owl o = new Owl();
        assertEquals(Arrays.asList(a1,a2),c10.getAviaryListForBird(o));
    }

    @Test
    public void getFoodReq() {
    }

    @Test
    public void aviaryLocBirdInfo() {
        String content = "Aviary1 Kochi sulfur-crested cockatoo Owl \n" +
                "Aviary2 Pune Owl Pigeon " + "\n";
        Owl o2 = new Owl();
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Aviary aviary1 = new Aviary("Aviary1","Kochi", Arrays.asList(myParrot,o2));
        Aviary aviary2 = new Aviary("Aviary2","Pune", Arrays.asList(new Owl(),new Pigeon()));
        Conservatory c = new Conservatory(Set.of(aviary1,aviary2));
        assertEquals(content,c.aviaryLocBirdInfo());
    }

    @Test
    public void getAviaryInfo() {
        String content = "The Aviary1 has the following birds that reside here as follows. \n" +
                "The Bird's name is sulfur-crested cockatoo. Some of the interesting characteristics of this bird are as follows \n" +
                "They have a short, curved beak and are known for their intelligence and ability to mimic sounds.\n" +
                "The Bird's name is Owl. Some of the interesting characteristics of this bird are as follows \n" +
                "They are distinguished by the facial disks that frame the eyes and bill.";
        Owl o2 = new Owl();
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Aviary aviary1 = new Aviary("Aviary1","Kochi", Arrays.asList(myParrot,o2));

        Conservatory c = new Conservatory(Set.of(aviary1));
        assertEquals(content,c.getAviaryInfo("Aviary1"));
    }
    @Test
    public void getAviaryInfo2() {
        Aviary a1 = new Aviary("hi","loc");
        Conservatory c = new Conservatory(Set.of(a1));
        assertEquals("No Aviary with that name present",c.getAviaryInfo("Aviary1"));
    }


}