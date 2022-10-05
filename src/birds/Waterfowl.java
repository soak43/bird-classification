package birds;

import java.util.*;

public class Waterfowl extends Bird implements WaterBird{

    private List<String> waterBodies = new ArrayList<String>();
    public List<String> getWaterBodies() {
        return waterBodies;
    }

    //private Set<String> allowedWaterBodies = new HashSet<>(Arrays.asList("arm of the sea", "arroyo", "artificial lake", "artificial pond", "aubach", "barachois", "basin", "bay", "bayou", "beck", "bight", "billabong", "boil","bog","bourn","brook","brooklet","burn","canal","channel","cove","creek","creek","delta", "distributary channel","drainage basin","draw","estuary","firth","fjord","gill","glacier","glacial pothole","gulf","harbor","hot spring", "impoundment", "inlet","kill", "lagoon","lake", "lick", "loch", "mangrove swamp", "marsh", "mediterranean sea", "mere", "mill pond", "moat", "mud puddle", "ocean", "oxbow lake", "phytotelma", "plunge pool", "pool", "pond", "port", "pothole", "puddle", "reflecting pool", "reservoir" ,"rill", "river", "rivulet", "roadstead", "run", "salt marsh", "sea", "sea loch", "sea lough", "seep", "slough", "source", "shoal", "sound", "spring", "strait", "stream", "stream pool", "streamlet", "subglacial lake", "swamp", "swimming pool", "tank", "tarn", "tide pool", "tributary", "affluent", "vernal pool", "wadi", "wash", "wetland"));

    public void setWaterBodies(List<String> waterBodies) {
        for (String waterBody : waterBodies ){
            if(allowedWaterBodies.contains(waterBody.trim().toLowerCase()) && waterBody != null && waterBody!= ""){
                this.waterBodies.add(waterBody.trim().toLowerCase());
            } else {
                throw new IllegalArgumentException("Enter a valid water body.");
            }
        }
    }

    public Waterfowl(){
        setType(Type.WATERFOWL);

    }

    public Waterfowl(String birdName) throws IllegalArgumentException{
        this();
        if(birdName.toLowerCase() == "ducks" || birdName.toLowerCase() == "swans" || birdName.toLowerCase() == "geese"){
            setName(birdName);
            setCharacteristic(Arrays.asList("They live near water sources"));
            setNumOfWings(2);
            setWaterBodies(Arrays.asList("lake", "reservoir", "pond", "river"));
            setFood(Arrays.asList("fish","aquatic invertebrates","insects"));
        } else {
            throw new IllegalArgumentException("Enter a bird from : SWANS, DUCKS OR GEESE");
        }
    }

    public Waterfowl(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, List<String> waterBodies, List<String> food){
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
        System.out.println("Race me");
    }




}
