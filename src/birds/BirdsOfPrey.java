package birds;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BirdsOfPrey extends Bird {
    /**
     * This is a default constructor which sets the type of bird by default when the object is created.
     */
    public BirdsOfPrey(){
        setType(Type.BIRDS_OF_PREY);
    }
    /**
     * This is a constructor with 1 parameter which represents constructor overloading. This constructor initializes the object
     * for 3 different instance birds of the type Birds of Prey.
     * The constructor initializes the object variables according to the different parameters.
     * Illegal Argument Exception is thrown if the user passes a bird name other than the 3 birds known to the constructor.
     * @param birdName
     * @throws IllegalArgumentException
     */
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
    /**
     * This is a constructor which takes the object variable values from the user.
     * This represents constructor overloading.
     * Here the user can pass the variable values for an unknown bird.
     * @param birdName
     * @param characteristics
     * @param isExtinct
     * @param numOfWings
     * @param food
     */
    public BirdsOfPrey(String birdName, List<String> characteristics, boolean isExtinct, int numOfWings, Set<String> food){

        this();
        setName(birdName);
        setNumOfWings(numOfWings);
        setCharacteristic(characteristics);
        setExtinct(isExtinct);
        setFood(food);
    }
    /**
     * Birds of prey have the ability to hunt. This is depicted using the hunt method.
     * @param prey
     * @return
     */
    public String Hunt(String prey){
        return "The bird is hunting";
    }

}
