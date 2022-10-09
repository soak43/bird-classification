package birds;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Owl extends Bird{

    /**
     * This is the default constructor which sets the type, the name of the bird,
     * a basic characteristic,the number of wings and the food it eats to default values as
     * provided in the assignment description
     */
    public Owl(){
        setType(Type.OWL);
        setName("Owl");
        setCharacteristic(Arrays.asList("They are distinguished by the facial disks that frame the eyes and bill."));
        setNumOfWings(2);
        setFood(Set.of("insects","fish","small mammals"));
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
    public Owl(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, Set<String> food){

        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
    }

    /**
     * Some specific behaviour of the owl is described here
     * @return
     */
    public String rotateHead(){
        return "I can rotate my head by 360 degrees";
    }






}
