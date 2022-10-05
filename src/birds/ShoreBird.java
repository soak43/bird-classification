package birds;

import java.util.*;

public class ShoreBird extends Bird implements WaterBird{



    private List<String> waterBodies = new ArrayList<String>();
//    private final Set<String> allowedWaterBodies = new HashSet<>(Arrays.asList("arm of the sea", "arroyo", "artificial lake", "artificial pond", "aubach", "barachois", "basin", "bay", "bayou", "beck", "bight", "billabong", "boil","bog","bourn","brook","brooklet","burn","canal","channel","cove","creek","creek","delta", "distributary channel","drainage basin","draw","estuary","firth","fjord","gill","glacier","glacial pothole","gulf","harbor","hot spring", "impoundment", "inlet","kill", "lagoon","lake", "lick", "loch", "mangrove swamp", "marsh", "mediterranean sea", "mere", "mill pond", "moat", "mud puddle", "ocean", "oxbow lake", "phytotelma", "plunge pool", "pool", "pond", "port", "pothole", "puddle", "reflecting pool", "reservoir" ,"rill", "river", "rivulet", "roadstead", "run", "salt marsh", "sea", "sea loch", "sea lough", "seep", "slough", "source", "shoal", "sound", "spring", "strait", "stream", "stream pool", "streamlet", "subglacial lake", "swamp", "swimming pool", "tank", "tarn", "tide pool", "tributary", "affluent", "vernal pool", "wadi", "wash", "wetland"));

    public void setWaterBodies(List<String> waterBodies) {
        for (String waterBody : waterBodies ){
            if(allowedWaterBodies.contains(waterBody.trim().toLowerCase()) && waterBody != null && waterBody!= ""){
                this.waterBodies.add(waterBody.trim().toLowerCase());
            } else {
                throw new IllegalArgumentException("Enter a valid water body.");
            }
        }
    }
    public ShoreBird(){
        setType(Type.SHOREBIRD);
    }

    public List<String> getWaterBodies() {
        return waterBodies;
    }

    public ShoreBird(String birdName){
        this();
        if(birdName.toLowerCase() == "great auk" || birdName.toLowerCase() == "horned puffin" || birdName.toLowerCase() == "African Jacana"){
            setName(birdName);
            setCharacteristic(Arrays.asList("They live near water sources"));
            setNumOfWings(2);
            switch (birdName.toLowerCase()) {
                case "great auk":
                    setWaterBodies(Arrays.asList("ocean"));
                    setExtinct(true);
                    break;
                case "horned puffin":
                    setWaterBodies(Arrays.asList("sea","ocean"));
                    break;
                case "african jacana":
                    setWaterBodies(Arrays.asList("wetland"));
                    break;
            }
            setFood(Arrays.asList("fish","aquatic invertebrates","insects"));
        }
        else {
            throw new IllegalArgumentException("Enter a bird from : GREAT AUK, HORNED PUFFIN, and AFRICAN JACANA");
        }
    }
    public ShoreBird(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, List<String> waterBodies, List<String> food){
        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setWaterBodies(waterBodies);
        setFood(food);
    }
   @Override
    public void swim() {
        System.out.println("Splish splash!");
    }
}
