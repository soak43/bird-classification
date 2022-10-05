package birds;

import java.util.*;

public class Bird extends Animalia{

    enum Type {
        BIRDS_OF_PREY,
        FLIGHTLESS_BIRDS,
        OWL,
        PARROT,
        PIGEON,
        SHOREBIRD,
        WATERFOWL
    }
    private Type type;
    private List<String> characteristic = new ArrayList<String>();
    private int numOfWings;
    private boolean isExtinct = false;
    private String name;

    private final Set<String> allowedFoods = new HashSet<>(Arrays.asList(
            "berries", "seeds", "fruits", "insects", "other birds", "eggs", "small mammals", "fish", "buds", "larvae", "aquatic invertebrates", "nuts", "vegetation"
    ));

    private List<String> food = new ArrayList<String>();


    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if(name == "" || name == null){
            throw new IllegalArgumentException("Enter a valid name");
        }else {
            this.name = name;
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<String> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(List<String> characteristic) {
        this.characteristic.addAll(characteristic);
    }

    public int getNumOfWings() {
        return numOfWings;
    }

    public void setNumOfWings(int numOfWings) throws IllegalArgumentException {
        if(numOfWings == 0 || numOfWings == 2) {
            this.numOfWings = numOfWings;
        }else {
            throw new IllegalArgumentException("Wings have to be 0 or 2.");
        }
    }

    public boolean isExtinct() {
        return isExtinct;
    }

    public void setExtinct(boolean extinct) {
        isExtinct = extinct;
    }

    public List<String> getFood() {
        return food;
    }

    public void setFood(List<String> foods) throws IllegalArgumentException{
        for (String foodItem : foods ){
            System.out.println(foodItem);
            if(allowedFoods.contains(foodItem.trim().toLowerCase()) && foodItem != null && foodItem != ""){
                food.add(foodItem.trim().toLowerCase());
            } else {
                throw new IllegalArgumentException("Enter a valid Food item");
            }
        }
    }


    public void fly(){
        System.out.println("Flap flap");
    }

    public void eat(List<String> food){
        System.out.println("The bird is eating");
    }

    public void chirp(){
        System.out.println("chirp chirp");
    }

    public void drink(){
        System.out.println("The bird is drinking");
    }

    public String toString() {
        return "Bird{" +
                ", type='" + type + '\'' +
                ", characteristic='" + characteristic + '\'' +
                ", extinct=" + isExtinct +
                ", numOfWings=" + numOfWings +
                ", favoriteFoods=" + food +
                '}';
    }

    @Override
    public void displayCharacteristics() {

        System.out.println(getCharacteristic());

    }
}


