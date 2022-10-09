package birds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightlessBirds extends Bird {
    /**
     * This is a default constructor which sets the type of bird by default when the object is created.
     */
    public FlightlessBirds() {
        setType(Type.FLIGHTLESS_BIRDS);
    }

    /**
     * This is a constructor with 1 parameter which represents constructor overloading. This constructor initializes the object
     * for 3 different instance birds of the type Birds of Prey.
     * The constructor initializes the object variables according to the different parameters.
     * Illegal Argument Exception is thrown if the user passes a bird name other than the 3 birds known to the constructor.
     * @param birdName
     * @throws IllegalArgumentException
     */
    public FlightlessBirds(String birdName) throws IllegalArgumentException {
        this();
        if (birdName.toLowerCase() == "emu" || birdName.toLowerCase() == "moa" || birdName.toLowerCase() == "kiwi") {
            if (birdName.toLowerCase() == "moa") {
                setExtinct(true);
            }
        } else {
            throw new IllegalArgumentException("Please enter one of the known birds : EMU, KIWI, MOA");
        }

        setName(birdName);
        setCharacteristic(Arrays.asList("They live on the ground"));
        setNumOfWings(0);
        if (birdName.toLowerCase() == "emu" || birdName.toLowerCase() == "moa") {
            setFood(Set.of("seeds", "fruits"));
        } else {
            setFood(Set.of("buds", "berries", "seeds"));
        }

    }

    /**
     * This is a constructor which takes the object variable values from the user.
     * This represents constructor overloading.
     * Here the user can pass the variable values for an unknown bird.
     * @param birdName
     * @param characteristics
     * @param noOfWings
     * @param isExtinct
     * @param food
     */
    public FlightlessBirds(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, Set<String> food) {
        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
    }
    /**
     * This method overrides the fly method in bird class.
     * It throws an Illegal Argument Exception since flightless birds cannot fly.
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public String fly() throws IllegalArgumentException{
        throw new IllegalArgumentException();
    }





}
