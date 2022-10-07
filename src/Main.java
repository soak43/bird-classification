import birds.Bird;
import birds.BirdsOfPrey;
import birds.FlightlessBirds;

public class Main {
    public static void main(String[] args) {
        FlightlessBirds fb = new FlightlessBirds("emu");
//      Bird b = bp;
        System.out.println("The bird isExtinct ?: " + fb.isExtinct());
        System.out.println("The number of wings is: " + fb.getNumOfWings());

    }
}