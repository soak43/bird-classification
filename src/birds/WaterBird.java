package birds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This Represents the functionality of birds that live close to waterbodies
 */
public interface WaterBird {
    /**
     * This is a constant variable that list all the possible water bodies where these kind of birds can live
     */
    final Set<String> allowedWaterBodies = new HashSet<>(Arrays.asList("arm of the sea", "arroyo", "artificial lake", "artificial pond", "aubach", "barachois", "basin", "bay", "bayou", "beck", "bight", "billabong", "boil","bog","bourn","brook","brooklet","burn","canal","channel","cove","creek","creek","delta", "distributary channel","drainage basin","draw","estuary","firth","fjord","gill","glacier","glacial pothole","gulf","harbor","hot spring", "impoundment", "inlet","kill", "lagoon","lake", "lick", "loch", "mangrove swamp", "marsh", "mediterranean sea", "mere", "mill pond", "moat", "mud puddle", "ocean", "oxbow lake", "phytotelma", "plunge pool", "pool", "pond", "port", "pothole", "puddle", "reflecting pool", "reservoir" ,"rill", "river", "rivulet", "roadstead", "run", "salt marsh", "sea", "sea loch", "sea lough", "seep", "slough", "source", "shoal", "sound", "spring", "strait", "stream", "stream pool", "streamlet", "subglacial lake", "swamp", "swimming pool", "tank", "tarn", "tide pool", "tributary", "affluent", "vernal pool", "wadi", "wash", "wetland"));

    /**
     * This functionality is expected to be implemented by the bird who live near water bodies
     * @return
     */
    public String swim();




}
