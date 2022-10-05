package birds;

import java.util.Arrays;
import java.util.List;

public class Parrot extends Bird {

    private String favoriteSaying;
    private int noOfWords;

    public Parrot() {
        setType(Type.PARROT);
    }

    public Parrot(String birdName) throws IllegalArgumentException{
        this();
        if(birdName.toLowerCase() == "sulfur-crested cockatoo" || birdName.toLowerCase() == "rose-ring parakeet" || birdName.toLowerCase() == "gray parrot"){
            setName(birdName);
            setNumOfWings(2);
            setFood(Arrays.asList("vegetation", "berries", "nuts","seeds"));
            setCharacteristic(Arrays.asList("They have a short, curved beak and are known for their intelligence and ability to mimic sounds."));
        }
        else{
            throw new IllegalArgumentException("Please enter one of the known birds : sulfur-crested cockatoo, rose-ring parakeet, gray parrot");
        }

    }

    public Parrot(String birdName, List<String> characteristics, int noOfWings, boolean isExtinct, List<String> food, int noOfWords, String favoriteSaying) {

        this();
        setName(birdName);
        setCharacteristic(characteristics);
        setNumOfWings(noOfWings);
        setExtinct(isExtinct);
        setFood(food);
        setFavoriteSaying(favoriteSaying);
        setNoOfWords(noOfWords);
    }

    public String getFavoriteSaying() {
        return favoriteSaying;
    }

    public void setFavoriteSaying(String favoriteSaying) {
        this.favoriteSaying = favoriteSaying;
    }
    public int getNoOfWords() {
        return noOfWords;
    }

    public void setNoOfWords(int noOfWords) {
        this.noOfWords = noOfWords;
    }

    public void speak(String favoriteSaying){
        System.out.println(favoriteSaying);
    }



}
