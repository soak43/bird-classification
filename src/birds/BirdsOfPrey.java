package birds;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BirdsOfPrey extends Bird {

    public BirdsOfPrey(){
        setType(Type.BIRDS_OF_PREY);
    }

    public BirdsOfPrey(String birdName) throws IllegalArgumentException{
        this();
        if(birdName.toLowerCase() == "hawks" || birdName.toLowerCase() == "eagles" || birdName.toLowerCase() == "osprey"){
            setCharacteristic(Arrays.asList("They have sharp, hooked beaks with visible nostrils."));
            setNumOfWings(2);
            setName(birdName);
            if(birdName.toLowerCase() == "osprey"){
                setFood(Set.of("small mammals", "other birds"));
            }
            else{
                setFood(Set.of("small mammals","insects"));
            }
        } else {
            throw new IllegalArgumentException("Enter a bird from : HAWKS, EAGLES OR OSPREY");
        }
    }

    public BirdsOfPrey(String birdName, List<String> characteristics, boolean isExtinct, int numOfWings, Set<String> food){

        this();
        setName(birdName);
        setNumOfWings(numOfWings);
        setCharacteristic(characteristics);
        setExtinct(isExtinct);
        setFood(food);
    }

    public String Hunt(String prey){
        return "The bird is hunting";
    }

}
