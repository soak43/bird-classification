package birds;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BirdsOfPreyTest {

    private BirdsOfPrey eagle;
    private BirdsOfPrey hawk;

    @Before
    public void setup(){
        eagle = new BirdsOfPrey("eagles");
        hawk = new BirdsOfPrey("hawks", Arrays.asList("They have sharp, hooked beaks with visible nostrils."), false, 2, Arrays.asList("Small mammals", "Small birds", "reptiles"));
    }


    @Test
    public void hunt() {
    }
}