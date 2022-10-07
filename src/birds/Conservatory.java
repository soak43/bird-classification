package birds;

import java.util.*;

public class Conservatory {

    private List<Aviary> aviaryList = new ArrayList<Aviary>();
    private Map<String,List> dictionary =  new TreeMap<>();
    Map<String,Integer> conservatoryFoodReq= new HashMap<>();

    private Aviary addAviary(String name,String location){
        Aviary aviary =new Aviary(name,location);
        aviaryList.add(aviary);
        return aviary;
    }
    private Aviary addAviary(String name, String location, Bird bird){
        Aviary aviary  = addAviary(name,location);
        aviary.addBird(bird);
        dictionary.put(bird.getName(), Arrays.asList(location));
        return aviary;
    }
    private Aviary addAviary(String name,String location,List<Bird> birds) {
        Aviary aviary  = addAviary(name,location);
        aviary.addBird(birds);
        for(Bird bird: birds){
            dictionary.put(bird.getName(), Arrays.asList(location));
        }
        return aviary;
    }

    private Bird AddBirdToConservatory(Bird bird){
        // check if there are open spots based on bird type
        for(Aviary aviary : aviaryList){
            if(bird.getType() == Bird.Type.BIRDS_OF_PREY || bird.getType() == Bird.Type.FLIGHTLESS_BIRDS
                    || bird.getType() == Bird.Type.WATERFOWL ){
                if(aviary.birdTypeSet.contains(bird.getType())){
                    aviary.addBird(bird);
                    if(dictionary.containsKey(bird.getName())){
                        dictionary.get(bird.getName()).add(aviary.location);
                    }else{
                        dictionary.put(bird.getName(), Arrays.asList(aviary.location));
                    }
                    return bird;
                }
            }
            else{
                if(!aviary.birdTypeSet.contains(Bird.Type.BIRDS_OF_PREY) &&
                        !aviary.birdTypeSet.contains(Bird.Type.FLIGHTLESS_BIRDS) &&
                        !aviary.birdTypeSet.contains(Bird.Type.WATERFOWL)){
                    aviary.addBird(bird);
                    if(dictionary.containsKey(bird.getName())){
                        dictionary.get(bird.getName()).add(aviary.location);
                    }else{
                        dictionary.put(bird.getName(), Arrays.asList(aviary.location));
                    }
                    return bird;
                }
            }
        }
        return null;

    }
    public Map<String,List> sortedAlphabetically(){
        return dictionary;
    }

    public List<Aviary> getAviaryListForBird(Bird bird){
        List<Aviary> aviariesFound = new ArrayList<>();
        for(Aviary aviary: aviaryList){
            if(aviary.birdList.contains(bird)){
                aviariesFound.add(aviary);
            }
        }
        return aviariesFound;
    }

    public Map<String,Integer> getFoodReq(){
        for(Aviary aviary: aviaryList){
            for(Map.Entry<String,Integer> entry : aviary.aviaryFoodStore.entrySet()){
                if(conservatoryFoodReq.containsKey(entry.getKey())){
                    conservatoryFoodReq.put(entry.getKey(),conservatoryFoodReq.get(entry.getKey()) + entry.getValue());
                }else{
                    conservatoryFoodReq.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return conservatoryFoodReq;
    }
    public void aviaryLocBirdInfo(){
        String content = "";
        for(Aviary aviary: aviaryList){
            content = content + aviary.getName() + aviary.getLocation() + " ";
            for(Bird bird: aviary.birdList){
                content = content + bird.getName() + " ";
            }
            content = content + "\n";
        }
        System.out.println(content);
    }
}
