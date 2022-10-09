package birds;

import java.util.*;

public class Waterfowl extends Bird implements WaterBird{
    /**
     * The instance variable waterBodies which stores a list of water bodies WaterBirds like to swim in
     */
    private List<String> waterBodies = new ArrayList<String>();
    /**
     * This is a getter method which returns the list of water bodies for the bird object.
     * @return
     */
    public List<String> getWaterBodies() {
        return waterBodies;
    }

    //private Set<String> allowedWaterBodies = new HashSet<>(Arrays.asList("arm of the sea", "arroyo", "artificial lake", "artificial pond", "aubach", "barachois", "basin", "bay", "bayou", "beck", "bight", "billabong", "boil","bog","bourn","brook","brooklet","burn","canal","channel","cove","creek","creek","delta", "distributary channel","drainage basin","draw","estuary","firth","fjord","gill","glacier","glacial pothole","gulf","harbor","hot spring", "impoundment", "inlet","kill", "lagoon","lake", "lick", "loch", "mangrove swamp", "marsh", "mediterranean sea", "mere", "mill pond", "moat", "mud puddle", "ocean", "oxbow lake", "phytotelma", "plunge pool", "pool", "pond", "port", "pothole", "puddle", "reflecting pool", "reservoir" ,"rill", "river", "rivulet", "roadstead", "run", "salt marsh", "sea", "sea loch", "sea lough", "seep", "slough", "source", "shoal", "sound", "spring", "strait", "stream", "stream pool", "streamlet", "subglacial lake", "swamp", "swimming pool", "tank", "tarn", "tide pool", "tributary", "affluent", "vernal pool", "wadi", "wash", "wetland"));
    /**
     * This is a mutator method which is used to set the waterbodies for a shorebird object.
     * If the water body is not present in the allowed water body list then this function throws an Illegal Argument Exception
     * @param waterBodies
     */
    public void setWaterBodies(List<String> waterBodies) {
        for (String waterBody : waterBodies ){
            if(allowedWaterBodies.contains(waterBody.trim().toLowerCase()) && waterBody != null && waterBody!= ""){
                this.waterBodies.add(waterBody.trim().toLowerCase());
            } else {
                throw new IllegalArgumentException("Enter a valid water body.");
            }
        }
    }
    /**
     * This is a default constructor which sets the type of bird by default when the object is created.
     */
    public Waterfowl(){
        setType(Type.WATERFOWL);
    }
    /**
     * This is a constructor with 1 parameter which represents constructor overloading. This constructor initializes the object
     * for 3 different instance birds of the type Water Fowl.
     * The constructor initializes the object variables according to the different parameters.
     * Illegal Argument Exception is thrown if the user passes a bird name other than the 3 birds known to the constructor.
     * @param birdName
     * @throws IllegalArgumentException
     */
    public Waterfowl(String birdName) throws IllegalArgumentException{
        this();
        if(birdName.toLowerCase() == "ducks" || birdName.toLowerCase() == "swans" || birdName.toLowerCase() == "geese"){
            setName(birdName);
            setCharacteristic(Arrays.asList("They live near water sources"));
            setNumOfWings(2);
            setWaterBodies(Arrays.asList("lake", "reservoir", "pond", "river"));
            setFood(Set.of("fish","aquatic invertebrates","insects"));
        } else {
            throw new IllegalArgumentException("Enter a bird from : SWANS, DUCKS OR GEESE");
        }
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
    public Waterfowl(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, List<String> waterBodies, Set<String> food){
        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setWaterBodies(waterBodies);
        setFood(food);
    }

    /**
     * This swim method overrides the swim method in the interface.
     * @return
     */
    @Override
    public String swim() {
        return "Race me";
    }




}
