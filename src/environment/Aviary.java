package environment;

import birds.Bird;
import birds.Bird.Type;

import java.util.*;

public class Aviary {

    /**
     * This instance variable represents the maximum number of birds one aviary can hold.
     */
    final int MAX_BIRDS_IN_AVIARY = 5;
    /**
     * This instance variable represents the aviary name.
     */
    private String name;
    /**
     * This instance variable stores the list of birds present in the aviary.
     */
    private List<Bird> birdList = new ArrayList<>();
    /**
     * This instance variable stores the type of birds present in the aviary. It is of type set to avoid duplicates.
     */
    private Set<Type> birdTypeSet = new HashSet<>();
    /**
     * This instance variable stores the food required according to the birds present in the aviary.
     * The food is stored in a hashmap to keep a record of the quantity of food required.
     */
    private Map<String,Integer> aviaryFoodStore = new HashMap<String,Integer>();

    /**
     * This instance variable stores the location of the aviary.
     */
    private String location;

    /**
     * This is a getter method which returns the name of the aviary.
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * This is a mutator method which sets the name of the aviary. If the name is null or if it is empty,
     * then the method throws an Illegal Argument Exception.
     * @param name
     * @throws IllegalArgumentException
     */
    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim() == "") {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }
    /**
     * This is the getter method which return the list of birds present in the aviary.
     * @return
     */
    public List<Bird> getBirdList() {
        return birdList;
    }

    /**
     * This is a getter method which returns the set of type of birds present in the aviary.
     * @return
     */
    public Set<Type> getBirdTypeSet() {
        return birdTypeSet;
    }

    /**
     * This is a getter method which returns the food required for an aviary in the form of a map.
     * @return
     */
    public Map<String, Integer> getAviaryFoodStore() {
        return aviaryFoodStore;
    }

    /**
     * This is the getter method which returns the location of the aviary.
     * @return
     */
    public String getLocation() {
        return location;
    }
    /**
     * This is the setter method which is used to set the location of the aviary. If the location is null or
     * if it is empty, the method throws an Illegal Argument Exception.
     * @param location
     * @throws IllegalArgumentException
     */

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
    /**
     * This method adds a bird in the aviary. There are a few things it checks before the adding the bird to the aviary.
     * 1. If the aviary bird list has the bird, then the method throws an Illegal Argument Exception.
     * 2. If the bird is null or if it is extinct then it cannot be added to the aviary.
     * Hence, the method will throw an exception.
     * 3. If the first 2 conditions are passed and if the birdlist is empty then the bird is directly added to the list.
     * 4. If the birdlist is not empty, then the birds present in the birdlist are checked.
     * If the bird parameter passed to the function is a flightless bird or waterfowl or a bird of prey, then it cannot be added
     * to the list with any bird other than itself.
     * If the bird parameter passed is a parrot, shorebird, pigeon or an owl,
     * and if the birdlist does not contain waterfowl, flightless bird or bird of prey then it can be added to the aviary.
     * @param bird
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalStateException
     */
    public Bird addBird(Bird bird) throws IllegalArgumentException, IllegalStateException {
        boolean exist = false;
        for(Bird birdInAviary: birdList){
            if(bird.equals(birdInAviary)){
                exist = true;
            }
        }
        if(!exist) {
            if (bird != null) {
                if (!bird.isExtinct()) {
                    if (birdList.isEmpty()) {
                        birdList.add(bird);
                        addFood(bird);
                        birdTypeSet.add(bird.getType());

                    }else if (birdList.size() < MAX_BIRDS_IN_AVIARY) {
                        System.out.println("Hello");
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
                    }else {
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
