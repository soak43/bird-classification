package birds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightlessBirds extends Bird {

    public FlightlessBirds() {
        setType(Type.FLIGHTLESS_BIRDS);
    }

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
            setFood(Arrays.asList("seeds", "fruits"));
        } else {
            setFood(Arrays.asList("buds", "berries", "seeds"));
        }

    }

    public FlightlessBirds(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, List<String> food) {
        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
    }

    @Override
    public void fly(){
        System.out.println("Oops, cannot fly");
    }





}
