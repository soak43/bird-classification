package environment;

import birds.Bird;

import java.util.*;

public class Conservatory {

    private Set<Aviary> aviarySet = new HashSet<>();
    private Map<String,List> dictionary =  new TreeMap<>();
    private Map<String,Integer> conservatoryFoodReq= new HashMap<>();

    public Set<Aviary> getAviarySet() {
        return aviarySet;
    }

    public Map<String, Integer> getConservatoryFoodReq() {
        return conservatoryFoodReq;
    }

    public Conservatory(Set<Aviary> aviarySet) {
        this.aviarySet = aviarySet;
        sortedAlphabetically(aviarySet);
        getFoodReq();

    }

    private Aviary addAviary(String name, String location){
        Aviary aviary = new Aviary(name,location);
        aviarySet.add(aviary);
        return aviary;
    }
    private Aviary addAviary(String name, String location, Bird bird){
        Aviary aviary  = addAviary(name,location,bird);
//        aviary.addBird(bird);
        dictionary.put(bird.getName(), Arrays.asList(location));
        aviarySet.add(aviary);
        return aviary;
    }
    private Aviary addAviary(String name,String location,List<Bird> birds) {
        Aviary aviary  = addAviary(name,location,birds);

//        aviary.addBird(birds);
//        for(Bird bird: birds){
//            dictionary.put(bird.getName(), Arrays.asList(location));
//        }
        aviarySet.add(aviary);
        return aviary;
    }
    public Aviary addAviary(Aviary aviary){
        aviarySet.add(aviary);
        return aviary;
    }
    public List<Aviary> addAviary(List<Aviary> aviaries){
        for( Aviary aviary: aviaries ){
            aviarySet.add(aviary);
        }
        return aviaries;
    }



    private Bird AddBirdToConservatory(Bird bird){
        // check if there are open spots based on bird type
        for(Aviary aviary : aviarySet){
            if(bird.getType() == Bird.Type.BIRDS_OF_PREY || bird.getType() == Bird.Type.FLIGHTLESS_BIRDS
                    || bird.getType() == Bird.Type.WATERFOWL ){
                if(aviary.getBirdTypeSet().contains(bird.getType())){
                    aviary.addBird(bird);
                    if(dictionary.containsKey(bird.getName())){
                        dictionary.get(bird.getName()).add(aviary.getLocation());
                    }else{
                        dictionary.put(bird.getName(), Arrays.asList(aviary.getLocation()));
                    }
                    return bird;
                }
            }
            else{
                if(!aviary.getBirdTypeSet().contains(Bird.Type.BIRDS_OF_PREY) &&
                        !aviary.getBirdTypeSet().contains(Bird.Type.FLIGHTLESS_BIRDS) &&
                        !aviary.getBirdTypeSet().contains(Bird.Type.WATERFOWL)){
                    aviary.addBird(bird);
                    if(dictionary.containsKey(bird.getName())){
                        dictionary.get(bird.getName()).add(aviary.getLocation());
                    }else{
                        dictionary.put(bird.getName(), Arrays.asList(aviary.getLocation()));
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

    public Map<String,List> sortedAlphabetically(Set<Aviary> aviarySet){
        for(Aviary aviary: aviarySet){
            for(Bird bird : aviary.getBirdList()){
                if(dictionary.containsKey(bird.getName())){
                    dictionary.get(bird.getName()).add(aviary.getLocation());
                }else{
                    dictionary.put(bird.getName(), Arrays.asList(aviary.getLocation()));
                }
            }
        }
        return dictionary;
    }

    public List<Aviary> getAviaryListForBird(Bird bird){
        List<Aviary> aviariesFound = new ArrayList<>();
        for(Aviary aviary: aviarySet){
            if(aviary.getBirdList().contains(bird)){
                aviariesFound.add(aviary);
            }
        }
        return aviariesFound;
    }

    public Map<String,Integer> getFoodReq(){
        for(Aviary aviary: aviarySet){
            for(Map.Entry<String,Integer> entry : aviary.getAviaryFoodStore().entrySet()){
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
        for(Aviary aviary: aviarySet){
            content = content + aviary.getName() + aviary.getLocation() + " ";
            for(Bird bird: aviary.getBirdList()){
                content = content + bird.getName() + " ";
            }
            content = content + "\n";
        }
        System.out.println(content);
    }
    public String getAviaryInfo(String aviaryName){
        for(Aviary aviary:aviarySet){
            if(aviary.getName() == aviaryName){
                return aviary.aviaryInfo();
            }
        }
        return "No Aviary with that name present";
    }

}
