package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

public class PigeonTest {


    private Pigeon pigeon1;
    private Pigeon pigeon2;

    @Before
    public void setupPigeon(){
        pigeon1 = new Pigeon();
        pigeon2 = new Pigeon("Pigeon", Arrays.asList("Pigeons (or doves) are known for feeding their young 'bird milk' very similar to the milk of mammals."), 2, false, Set.of("seeds","fruits","berries","vegetation"));
    }

    @Test
    public void testConstructorOne(){

        assertEquals("Pigeon",pigeon1.getName());
        assertEquals(Bird.Type.PIGEON,pigeon1.getType());
        assertEquals(2,pigeon1.getNumOfWings());
        assertEquals(Arrays.asList("Pigeons (or doves) are known for feeding their young 'bird milk' very similar to the milk of mammals."),pigeon1.getCharacteristic());
        assertEquals(Set.of("seeds","fruits","berries","vegetation"),pigeon1.getFood());
    }

    @Test
    public void testConstructorTwo(){
        assertEquals("Pigeon",pigeon2.getName());
        assertEquals(Bird.Type.PIGEON,pigeon2.getType());
        assertEquals(2,pigeon2.getNumOfWings());
        assertEquals(Arrays.asList("Pigeons (or doves) are known for feeding their young 'bird milk' very similar to the milk of mammals."),pigeon1.getCharacteristic());
        assertEquals(Set.of("fruits", "seeds", "vegetation", "berries"),pigeon1.getFood());
    }

    @Test
    public void feedYoungOnesMilk() {
        assertEquals("feed",pigeon2.feedYoungOnes());
    }
}