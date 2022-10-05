package birds;

import java.util.Arrays;
import java.util.List;

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
                setFood(Arrays.asList("Small mammals", "Small birds", "reptiles"));
            }
            else{
                setFood(Arrays.asList("Small mammals","Insects"));
            }
        } else {
            throw new IllegalArgumentException("Enter a bird from : HAWKS, EAGLES OR OSPREY");
        }
    }

    public BirdsOfPrey(String birdName, List<String> characteristics, boolean isExtinct, int numOfWings, List<String> food){

        this();
        setName(birdName);
        setNumOfWings(numOfWings);
        setCharacteristic(characteristics);
        setExtinct(isExtinct);
        setFood(food);

    }

    public void Hunt(String prey){

        System.out.println("I will Kill you");
    }






}
