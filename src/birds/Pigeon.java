package birds;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Pigeon extends Bird{

    public Pigeon(){
        setName("Pigeon");
        setType(Type.PIGEON);
        setNumOfWings(2);
        setCharacteristic(Arrays.asList("Pigeons (or doves) are known for feeding their young 'bird milk' very similar to the milk of mammals."));
        setFood(Set.of("seeds", "fruits", "berries", "vegetation"));
    }


    public Pigeon(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, Set<String> food){
        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
    }

    public String feedYoungOnes(){
        return "feed";
    }







}
