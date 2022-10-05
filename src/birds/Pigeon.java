package birds;

import java.util.Arrays;
import java.util.List;

public class Pigeon extends Bird{

    public Pigeon(){
        setName("Pigeon");
        setType(Type.PIGEON);
        setNumOfWings(2);
        setCharacteristic(Arrays.asList("Pigeons (or doves) are known for feeding their young 'bird milk' very similar to the milk of mammals."));
        setFood(Arrays.asList("seeds","fruits","berries","vegetation"));
    }


    public Pigeon(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, List<String> food){
        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
    }

    public void feedYoungOnesMilk(){
        System.out.println("feed");
    }







}
