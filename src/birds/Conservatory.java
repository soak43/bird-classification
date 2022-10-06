package birds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conservatory {

    private List<Aviary> aviaryList = new ArrayList<Aviary>();

    Map<String,Integer> foodTracker= new HashMap<>();

    private Aviary addAviary(String name,String location){
        Aviary aviary =new Aviary(name,location);
        aviaryList.add(aviary);
        return aviary;
    }
    private Aviary addAviary(String name, String location, Bird bird){
        Aviary aviary  = addAviary(name,location);
        aviary.addBird(bird);
        return aviary;
    }
    private Aviary addAviary(String name,String location,List<Bird> birds) {
        Aviary aviary  = addAviary(name,location);
        aviary.addBird(birds);
        return aviary;
    }

    private Bird AddBirdToConservatory(Bird bird){
        // check if there are open spots based on bird type
        for(Aviary aviary : aviaryList){
            if(bird.getType() == Bird.Type.BIRDS_OF_PREY || bird.getType() == Bird.Type.FLIGHTLESS_BIRDS
                    || bird.getType() == Bird.Type.WATERFOWL ){
                if(aviary.birdTypeSet.contains(bird.getType())){
                    aviary.addBird(bird);
                    return bird;
                }
            }
            else{
                if(!aviary.birdTypeSet.contains(Bird.Type.BIRDS_OF_PREY) &&
                        !aviary.birdTypeSet.contains(Bird.Type.FLIGHTLESS_BIRDS) &&
                        !aviary.birdTypeSet.contains(Bird.Type.WATERFOWL)){
                    aviary.addBird(bird);
                    return bird;
                }
            }
        }
        return null;

    }

}
