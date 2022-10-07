package environment;

import birds.Bird;
import birds.Bird.Type;

import java.util.*;

public class Aviary {


    final int MAX_BIRDS_IN_AVIARY = 5;
    private String name;
    private List<Bird> birdList = new ArrayList<>();

    private Set<Type> birdTypeSet = new HashSet<>();

    private HashMap<String, Integer> aviaryFoodStore = new HashMap<String, Integer>();

    private String location;


    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if(name == null || name == ""){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public List<Bird> getBirdList() {
        return birdList;
    }


    public Set<Type> getBirdTypeSet() {
        return birdTypeSet;
    }


    public HashMap<String, Integer> getAviaryFoodStore() {
        return aviaryFoodStore;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) throws IllegalArgumentException{
        if(location == null || location == ""){
            throw new IllegalArgumentException("Location cannot be empty or null");
        }
        this.location = location;
    }
    /*
    * In order to initialize an Aviary, name and location are necessary
    * */
    public Aviary(String name, String location) throws IllegalArgumentException{
        if(name.trim() == "" || location.trim()  == ""){
            throw new IllegalArgumentException("Enter a valid location or name");
        }else{
            setName(name);
            setLocation(location);
        }
    }
    public Aviary(String name, String location, Bird bird){
        this(name,location);
        addBird(bird);
        addFood(bird);
    }
    public Aviary(String name, String location, List<Bird> userBirdList) {
        this(name,location);
        for(Bird bird : userBirdList){
            addBird(bird);
            addFood(bird);
        }
    }
    private String generateBirdInfo(Bird bird){
        String content = "The Bird's name is " + bird.getName() + ". Some of the interesting characteristics of this bird are as follows \n" + bird.displayCharacteristics();
        return content;
    }

    public String aviaryInfo(){
        if(birdList.size()!=0) {
            String content = "The" + name + " aviary has the following birds that reside here as follows. ";
            for (Bird b : birdList) {
                content = content + generateBirdInfo(b);
            }
            content += ".";
            return content;
        } else {
            return "The" + name + " aviary has no birds as of now";
        }
    }

    public Bird addBird(Bird bird) throws IllegalArgumentException,IllegalStateException {
        if (!bird.isExtinct()) {
            if (birdList.isEmpty()) {
                birdList.add(bird);
                addFood(bird);
                birdTypeSet.add(bird.getType());

            } else if (birdList.size() <= MAX_BIRDS_IN_AVIARY) {
                if(bird.getType() == Type.BIRDS_OF_PREY || bird.getType() == Type.FLIGHTLESS_BIRDS || bird.getType() == Type.WATERFOWL ){
                    if (birdTypeSet.contains(Type.BIRDS_OF_PREY) && birdTypeSet.size() == 1 && bird.getType() == Type.BIRDS_OF_PREY) {
                        birdList.add(bird);
                        addFood(bird);
                    } else if (birdTypeSet.contains(Type.FLIGHTLESS_BIRDS) && birdTypeSet.size() == 1 && bird.getType() == Type.FLIGHTLESS_BIRDS) {
                        birdList.add(bird);
                        addFood(bird);
                    } else if (birdTypeSet.contains(Type.WATERFOWL) && birdTypeSet.size() == 1 && bird.getType() == Type.WATERFOWL) {
                        birdList.add(bird);
                        addFood(bird);
                    } else {
                        throw new IllegalArgumentException("Cannot add other types to an aviary containing " + bird.getType());
                    }
                }else {
                    birdList.add(bird);
                    addFood(bird);
                    birdTypeSet.add(bird.getType());
                }
                return bird;
            } else{
                throw new IllegalStateException("The Aviary is full");
            }
        } else {
            throw new IllegalArgumentException("Bird is Extinct");
        }
        return null;
    }

    public List<Bird> addBird(List<Bird> birds){
        if(birds != null && !birds.isEmpty() ) {
            for (Bird bird : birds) {
                addBird(bird);
                addFood(bird);
            }
            return birdList;
        }
        return null;
    }

    private void addFood(Bird bird){
        for(String food: bird.getFood()){
            if(aviaryFoodStore.containsKey(food)){
                aviaryFoodStore.put(food, aviaryFoodStore.get(food) + 1);
            }
            else{
                aviaryFoodStore.put(food,1);
            }
        }
    }
}
