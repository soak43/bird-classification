import birds.Bird;
import birds.BirdsOfPrey;
import birds.FlightlessBirds;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        FlightlessBirds fb = new FlightlessBirds("emu");
////      Bird b = bp;
//        System.out.println("The bird isExtinct ?: " + fb.isExtinct());
//        System.out.println("The number of wings is: " + fb.getNumOfWings());

        BirdsOfPrey b = new BirdsOfPrey();
        b.setCharacteristic(Arrays.asList("They have sharp, hooked beaks with visible nostrils.","They have sharp claws"));
        System.out.println(b.displayCharacteristics());
        System.out.println(b.getCharacteristic());

    }
}