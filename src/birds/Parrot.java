package birds;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Parrot extends Bird {
    /**
     * This instance variable stores the parrot's favorite saying in a string.
     */
    private String favoriteSaying;
    /**
     * This instance variable keeps a record of the number of words the parrot can speak.
     */
    private int noOfWords;
    /**
     * This is a default constructor which set the type of bird as Parrot by default.
     */
    public Parrot() {
        setType(Type.PARROT);
    }

    /**
     * This is a constructor with 1 parameter which represents constructor overloading. This constructor initializes the object
     * for 3 different instance birds of the type Birds of Prey.
     * The constructor initializes the object variables according to the different parameters.
     * Illegal Argument Exception is thrown if the user passes a bird name other than the 3 birds known to the constructor.
     * @param birdName
     * @throws IllegalArgumentException
     */
    public Parrot(String birdName) throws IllegalArgumentException{
        this();
        if(birdName.toLowerCase() == "sulfur-crested cockatoo" || birdName.toLowerCase() == "rose-ring parakeet" || birdName.toLowerCase() == "gray parrot"){
            setName(birdName);
            setNumOfWings(2);
            setFood(Set.of("vegetation", "berries", "nuts", "seeds"));
            setCharacteristic(Arrays.asList("They have a short, curved beak and are known for their intelligence and ability to mimic sounds."));
        }
        else{
            throw new IllegalArgumentException("Please enter one of the known birds : sulfur-crested cockatoo, rose-ring parakeet, gray parrot");
        }

    }

    /**
     * This is a constructor which takes the object variable values from the user.
     * This represents constructor overloading.
     * Here the user can pass the variable values for an unknown bird.     *
     * @param birdName
     * @param characteristics
     * @param noOfWings
     * @param isExtinct
     * @param food
     * @param noOfWords
     * @param favoriteSaying
     */
    public Parrot(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, Set<String> food, int noOfWords, String favoriteSaying) {

        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
        setFavoriteSaying(favoriteSaying);
        setNoOfWords(noOfWords);
    }
    /**
     * This is a getter method which returns the favourite saying
     * @return
     */
    public String getFavoriteSaying() {
        return favoriteSaying;
    }
    /**
     * This is a mutator method which is used to set the parrot's favourite saying.
     * @param favoriteSaying
     */
    public void setFavoriteSaying(String favoriteSaying) {
        this.favoriteSaying = favoriteSaying;
    }
    /**
     * This is a getter method which returns the number of words spoken by the parrot
     * @return
     */
    public int getNoOfWords() {
        return noOfWords;
    }
    /**
     * This is a mutator method which is used to set the number of words a parrot can speak.
     * @param noOfWords
     */
    public void setNoOfWords(int noOfWords) {
        this.noOfWords = noOfWords;
    }
    /**
     * A parrot is able to mimic sounds. The speak method represents this ability.
     * @param favoriteSaying
     * @return
     */
    public String speak(String favoriteSaying){
        return "The parrot is saying - " + favoriteSaying;
    }



}
