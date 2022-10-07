package birds;

import java.util.Arrays;
import java.util.List;

public class Owl extends Bird{


    public Owl(){
        setType(Type.OWL);
        setName("Owl");
        setCharacteristic(Arrays.asList("They are distinguished by the facial disks that frame the eyes and bill."));
        setNumOfWings(2);
        setFood(Arrays.asList("insects","fish","small mammals"));
    }

    public Owl(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, List<String> food){

        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
    }

    public String rotateHead(){
        return "I can rotate my head by 360 degrees";
    }






}
