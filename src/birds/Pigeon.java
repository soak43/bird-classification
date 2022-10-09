package birds;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Pigeon extends Bird{
    /**
     * This is the default constructor which sets the type, the name of the bird,
     * a basic characteristic,the number of wings and the food it eats to default values as
     * provided in the assignment description
     */
    public Pigeon(){
        setName("Pigeon");
        setType(Type.PIGEON);
        setNumOfWings(2);
        setCharacteristic(Arrays.asList("Pigeons (or doves) are known for feeding their young 'bird milk' very similar to the milk of mammals."));
        setFood(Set.of("seeds", "fruits", "berries", "vegetation"));
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
    public Pigeon(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, Set<String> food){
        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
    }
    /**
     * Pigeons feed their young ones milk. This method represents this ability.
     * @return
     */
    public String feedYoungOnes(){
        return "feed";
    }







}
