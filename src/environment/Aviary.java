package environment;

import birds.Bird;
import birds.Bird.Type;

import java.util.*;

public class Aviary {


    final int MAX_BIRDS_IN_AVIARY = 5;
    private String name;
    private List<Bird> birdList = new ArrayList<>();

    private Set<Type> birdTypeSet = new HashSet<>();

    private Map<String,Integer> aviaryFoodStore = new HashMap<String,Integer>();

    private String location;


    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim() == "") {
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


    public Map<String, Integer> getAviaryFoodStore() {
        return aviaryFoodStore;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) throws IllegalArgumentException {
        if (location == null || location.trim() == "") {
            throw new IllegalArgumentException("Location cannot be empty or null");
        }
        this.location = location;
    }

    /*
     * In order to initialize an Aviary, name and location are necessary
     * */
    public Aviary(String name, String location) throws IllegalArgumentException {

            setName(name);
            setLocation(location);

    }

    public Aviary(String name, String location, Bird bird) {
        this(name, location);
        addBird(bird);
        addFood(bird);
    }

    public Aviary(String name, String location, List<Bird> userBirdList) throws IllegalArgumentException{
        this(name, location);
        if(userBirdList == null || userBirdList.isEmpty()){
            throw new IllegalArgumentException("User bird list was empty or null");
        }else {
            for (Bird bird : userBirdList) {
                addBird(bird);
                addFood(bird);
            }
        }
    }

    private String generateBirdInfo(Bird bird) throws IllegalArgumentException {
        String content = "The Bird's name is " + bird.getName() + ". Some of the interesting characteristics of this bird are as follows \n" + bird.displayCharacteristics();
        return content;
    }

    public String Info() {
        if (birdList.size() != 0) {
            String content = "The " + name + " has the following birds that reside here as follows. \n";
            for (Bird b : birdList) {
                content = content + generateBirdInfo(b)  +"\n";
            }
            content = content.substring(0, content.length() - 1);
            return content;
        } else {
            return "The " + name + " has no birds as of now";
        }
    }

    public Bird addBird(Bird bird) throws IllegalArgumentException, IllegalStateException {
        if(!birdList.contains(bird)) {
            if (bird != null) {
                if (!bird.isExtinct()) {
                    if (birdList.isEmpty()) {
                        birdList.add(bird);
                        addFood(bird);
                        birdTypeSet.add(bird.getType());

                    } else if (birdList.size() < MAX_BIRDS_IN_AVIARY) {
                        if (bird.getType() == Type.BIRDS_OF_PREY || bird.getType() == Type.FLIGHTLESS_BIRDS || bird.getType() == Type.WATERFOWL) {
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
                        } else {
                            birdList.add(bird);
                            addFood(bird);
                            birdTypeSet.add(bird.getType());
                        }
                        return bird;
                    } else {
                        throw new IllegalStateException("The Aviary is full");
                    }
                } else {
                    throw new IllegalArgumentException("Bird is Extinct");
                }
            } else {
                throw new IllegalArgumentException("Bird Can't be null");
            }

        }
        return bird;
    }

    public List<Bird> addBird(List<Bird> birds){
        if (birds != null) {
            if(!birds.isEmpty()) {
                for (Bird bird : birds) {
                    addBird(bird);
                    addFood(bird);
                }
                return birdList;
            }else {
                throw new IllegalArgumentException("Bird List provided by user cannot be empty");
            }

        }else{
            throw new IllegalArgumentException("Bird List cannot be null");
        }

    }

    private void addFood(Bird bird) {
        for (String food : bird.getFood()) {
            if (aviaryFoodStore.containsKey(food)) {
                aviaryFoodStore.put(food, Integer.valueOf(aviaryFoodStore.get(food)) + 1);
            } else {
                aviaryFoodStore.put(food, 1);
            }
        }
    }
}
