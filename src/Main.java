import birds.*;
import environment.Aviary;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Parrot myParrot = new Parrot("sulfur-crested cockatoo");
        Owl o2 = new Owl();
//        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot,o2));
//      Bird b = bp;
//        System.out.println("The bird isExtinct ?: " + fb.isExtinct());
//        System.out.println("The number of wings is: " + fb.getNumOfWings());
        System.out.println("+++++++++++++++++++++++++++");


//        Parrot myParrot1 = new Parrot("sulfur-crested cockatoo");
//        Owl o3 = new Owl();
//        Aviary myAviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot1,o3));
//
//        aviary.addBird(Arrays.asList(new Pigeon(),new Owl()));
//        System.out.println(aviary.getAviaryFoodStore());
//
//        Parrot myParrot1 = new Parrot("sulfur-crested cockatoo");
//        Pigeon pigeon = new Pigeon();
//        Owl o22 = new Owl();
//
//        Owl o3 = new Owl();
//        Owl o4 = new Owl();
//
//
//        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", Arrays.asList(myParrot1,o22,o3,o4,pigeon));
//
//        aviary.addBird(new Pigeon());
//        System.out.println(aviary.getBirdList().size());
        List<Bird> myBirds = new ArrayList<>();
        for(int i = 0 ; i <  3; i ++){
            myBirds.add(new Waterfowl());
        }

        Aviary aviary = new Aviary("Anshul's Aviary","Kochi", myBirds);

        aviary.addBird(new Pigeon());
        System.out.println(aviary.getBirdTypeSet());
    }
}