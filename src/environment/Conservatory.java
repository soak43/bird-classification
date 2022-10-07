package environment;

import birds.Bird;

import java.util.*;

public class Conservatory {

    private Set<Aviary> aviarySet = new HashSet<>();
    private Map<String,List> alphabeticalOrderDictionaryOfBirds =  new TreeMap<>();
    private Map<String,Integer> conservatoryFoodReq= new HashMap<>();

    public Set<Aviary> getAviarySet() {
        return aviarySet;
    }

    public Map<String, Integer> getConservatoryFoodReq() {
        return conservatoryFoodReq;
    }

    public Conservatory(Set<Aviary> aviarySet) {

        this.aviarySet = aviarySet;
        sortAlphabetically();
        getFoodReq();

    }
//   GOOD  add new aviary
    public Aviary addAviary(Aviary aviary) throws IllegalStateException{
        if(aviarySet.size()<20){
            aviarySet.add(aviary);
            sortAlphabetically();
            getFoodReq();
            return aviary;
        } else{
            throw new IllegalStateException("Cannot add more than 20 aviaries per conservatory");
        }
    }
// GOOD  add New Aviary without a bird Good by name and loc
    private Aviary addAviary(String name, String location){
        Aviary aviary = new Aviary(name,location);
        addAviary(aviary);
        return aviary;
    }
//    GOOD add New avairy with a bird name loc and bird
    private Aviary addAviary(String name, String location, Bird bird){
        Aviary aviary  = addAviary(name,location);
        aviary.addBird(bird);
        addAviary(aviary);
//        dictionary.put(bird.getName(), Arrays.asList(location));
//        aviarySet.add(aviary);
        return aviary;
    }
//    GOOD
    private Aviary addAviary(String name,String location,List<Bird> birds) {
        Aviary aviary = addAviary(name, location);
        for (Bird bird : birds) {
            aviary.addBird(bird);
        }
        addAviary(aviary);
        return aviary;
    }

//GOOD
    public List<Aviary> addAviary(List<Aviary> aviaries){
        for( Aviary aviary: aviaries ){
            addAviary(aviary);
        }
        return aviaries;
    }


//deciding
    private Boolean AddBirdToConservatory(Bird bird) throws IllegalArgumentException,IllegalStateException {
        // check if there are open spots based on bird type
        boolean added = false;
        for (Aviary aviary : aviarySet) {
            if (!added) {
                try {
                    aviary.addBird(bird);
                    return true;
                } catch (IllegalArgumentException | IllegalStateException e) {

                }
            }
        }
        return false;
    }

// good
    public Map<String,List> getAlphabeticalOrderDictionaryOfBirds(){
        return  alphabeticalOrderDictionaryOfBirds;
    }
//good
    public Map<String,List> sortAlphabetically(){
        for(Aviary aviary: aviarySet){
            for(Bird bird : aviary.getBirdList()){
                if(alphabeticalOrderDictionaryOfBirds.containsKey(bird.getName())){
                    alphabeticalOrderDictionaryOfBirds.get(bird.getName()).add(aviary.getLocation());
                }else{
                    alphabeticalOrderDictionaryOfBirds.put(bird.getName(), Arrays.asList(aviary.getLocation()));
                }
            }
        }
        return alphabeticalOrderDictionaryOfBirds;
    }
// good
    public List<Aviary> getAviaryListForBird(Bird bird){
        List<Aviary> aviariesFound = new ArrayList<>();
        for(Aviary aviary: aviarySet){
            if(aviary.getBirdList().contains(bird)){
                aviariesFound.add(aviary);
            }
        }
        return aviariesFound;
    }
//Good
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
//    good
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
//    good
    public String getAviaryInfo(String aviaryName){
        for(Aviary aviary:aviarySet){
            if(aviary.getName() == aviaryName){
                return aviary.Info();
            }
        }
        return "No Aviary with that name present";
    }

}
