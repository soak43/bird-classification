import birds.*;
import environment.Aviary;
import environment.Conservatory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        FlightlessBirds fb = new FlightlessBirds("emu");
////      Bird b = bp;
//        System.out.println("The bird isExtinct ?: " + fb.isExtinct());
//        System.out.println("The number of wings is: " + fb.getNumOfWings());
        Set<Aviary> aviarySet;
        Aviary aviary1;
        Parrot myParrot;
        Owl o2;
        Aviary aviary2;
        Conservatory conservatory;

//        BirdsOfPrey b = new BirdsOfPrey();
//        b.setCharacteristic(Arrays.asList("They have sharp, hooked beaks with visible nostrils.","They have sharp claws"));
//        System.out.println(b.displayCharacteristics());
//        System.out.println(b.getCharacteristic());

//
//        aviary1 = new Aviary("Anshul's Aviary", "Kochi");
//        myParrot = new Parrot("sulfur-crested cockatoo");
//        o2 = new Owl();
//        aviary2 = new Aviary("Anshul's Aviary", "Kochi", Arrays.asList(myParrot, o2));
//        aviarySet = new HashSet<>();
//        aviarySet.addAll(Arrays.asList(aviary1, aviary2));
//        conservatory = new Conservatory(aviarySet);
//        conservatory.getConservatoryFoodReq();
//        System.out.println(conservatory.getConservatoryFoodReq());

        Set<Aviary> aviaries = new HashSet<>();
        Aviary aviary1add = new Aviary("Sayali's Aviary","pune");
        aviaries.add(aviary1add);
        Conservatory conservatory2 = new Conservatory(aviaries);
        Aviary aviary2add = new Aviary("Anshul's Aviary","Kochi");
        conservatory2.addAviary(aviary2add);
    }
}