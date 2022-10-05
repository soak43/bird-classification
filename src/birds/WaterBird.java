package birds;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface WaterBird {

    final Set<String> allowedWaterBodies = new HashSet<>(Arrays.asList("arm of the sea", "arroyo", "artificial lake", "artificial pond", "aubach", "barachois", "basin", "bay", "bayou", "beck", "bight", "billabong", "boil","bog","bourn","brook","brooklet","burn","canal","channel","cove","creek","creek","delta", "distributary channel","drainage basin","draw","estuary","firth","fjord","gill","glacier","glacial pothole","gulf","harbor","hot spring", "impoundment", "inlet","kill", "lagoon","lake", "lick", "loch", "mangrove swamp", "marsh", "mediterranean sea", "mere", "mill pond", "moat", "mud puddle", "ocean", "oxbow lake", "phytotelma", "plunge pool", "pool", "pond", "port", "pothole", "puddle", "reflecting pool", "reservoir" ,"rill", "river", "rivulet", "roadstead", "run", "salt marsh", "sea", "sea loch", "sea lough", "seep", "slough", "source", "shoal", "sound", "spring", "strait", "stream", "stream pool", "streamlet", "subglacial lake", "swamp", "swimming pool", "tank", "tarn", "tide pool", "tributary", "affluent", "vernal pool", "wadi", "wash", "wetland"));

    public void swim();




}
