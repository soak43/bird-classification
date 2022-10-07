package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OwlTest {

    private Owl O1;
    private Owl O2;

    @Before
    public void setup(){
        O1 = new Owl("owl", Arrays.asList("They are distinguished by the facial disks that frame the eyes and bill."), 2, false,Arrays.asList("insects","fish","small mammals"));
        O2 = new Owl();
    }

    @Test
    public void testConstructor1(){
        assertEquals(Bird.Type.OWL, O2.getType());
        assertEquals(2,O2.getNumOfWings());
        assertEquals(Bird.Type.OWL, O2.getType());
        assertEquals(Arrays.asList("They are distinguished by the facial disks that frame the eyes and bill."), O2.getCharacteristic());
        assertEquals(Arrays.asList("insects","fish","small mammals"), O2.getFood());
    }

    @Test
    public void testIsExtinct(){
        assertEquals(false,O1.isExtinct());
    }

    @Test
    public void rotateHead() {
        assertEquals("I can rotate my head by 360 degrees", O1.rotateHead());
        assertEquals("I can rotate my head by 360 degrees", O2.rotateHead());
    }
}