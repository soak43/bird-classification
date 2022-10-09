package birds;

import java.util.*;

public class Bird extends Animalia {
    /**
     * The Enum Type represents the Different Types of Bird that are currently intended to be used along
     * with this project. The decision to use an enum was taken as this is something that is unlikely to
     * change during the course of this project and is less error-prone when compared to a string.
     */
    public enum Type {
        BIRDS_OF_PREY,
        FLIGHTLESS_BIRDS,
        OWL,
        PARROT,
        PIGEON,
        SHOREBIRD,
        WATERFOWL
    }

    /**
     * This instance variable represents the type of the bird.
     */
    private Type type;
    /**
     * This instance variable characteristics is a list of strings. This datatype was chosen to hold multiple number of characteristics.
     */
    private List<String> characteristic = new ArrayList<String>();
    /**
     * This instance variable represents the number of wings the bird posses. There is a limitation
     * on the values that this variable can take, which is either 0 or 2
     */
    private int numOfWings;
    /**
     * This instance variable holds a boolean value for whether the bird is extinct. The default value is set to false.
     * The value will be updated to true only if the bird is extinct.
     */
    private boolean isExtinct = false;
    /**
     * This instance variable represents the name of the bird that is being instantiated.
     */
    private String name;
    /**
     * This instance variable holds a list of allowed food items. While adding the food items for a bird,
     */
    public final static Set<String> allowedFoods = new HashSet<>(Arrays.asList(
            "berries", "seeds", "fruits", "insects", "other birds", "eggs", "small mammals", "fish", "buds", "larvae", "aquatic invertebrates", "nuts", "vegetation"
    ));
    /**
     * This instance variable holds the food that the bird will consume. A set was chosen as the
     * underlying data structure to remove duplicates
     */
    private Set<String> food = new HashSet<>();
    /**
     * This method returns the name of the bird.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This is the setter method for the instance variable name. The checks in terms of what values
     * are accepted are enforced by this method, are as follows
     * -No null values will be accepted
     * -No empty strings will be accepted
     * An IllegalArgumentException Will be thrown if these checks are violated.
     * @param name
     * @throws IllegalArgumentException
     */
    public void setName(String name) throws IllegalArgumentException {
        if (name.trim() == "" || name == null) {
            throw new IllegalArgumentException("Enter a valid name");
        } else {
            this.name = name;
        }
    }
    /**
     * This is the getter method returns the type of the bird.
     * @return
     */
    public Type getType() {
        return type;
    }

    /**
     *This is the setter method which accepts
     * @param type
     */
    public void setType(Type type) {
        this.type = type;
    }
    /**
     * This is the getter method which returns the list of characteristics for a particular bird object.
     * @return
     */
    public List<String> getCharacteristic() {
        return characteristic;
    }

    /**
     * This is the setter method of the characteristic variable of the bird which takes in a list of characteristics
     * of the particular bir
     * @param characteristic
     */
    public void setCharacteristic(List<String> characteristic) {
        this.characteristic.addAll(characteristic);
    }
    /**
     * This is a getter method which return the number of wings the bird object has.
     * @return
     */
    public int getNumOfWings() {
        return numOfWings;
    }

    /**
     * This is the setter method for setting the number of wings a bird has. This checks whether the
     * input param is either 2 or 0. If it is neither of those two values an IllegalArgument
     * exception is thrown by this method
     * @param numOfWings
     * @throws IllegalArgumentException
     */
    public void setNumOfWings(int numOfWings) throws IllegalArgumentException {
        if (numOfWings == 0 || numOfWings == 2) {
            this.numOfWings = numOfWings;
        } else {
            throw new IllegalArgumentException("Wings have to be 0 or 2.");
        }
    }
    /**
     * This method returns the status of extinction of the bird i.e whether it is extinct or not
     * @return
     */

    public boolean isExtinct() {
        return isExtinct;
    }

    /**
     * This is mutator method through which the value of isExtinct variable can be changed.
     * @param extinct
     */
    public void setExtinct(boolean extinct) {
        isExtinct = extinct;
    }
    /**
     * This is an accessor method which return the set of food for a particular bird object.
     * @return
     */
    public Set<String> getFood() {
        return food;
    }

    /**
     * This is the setter method for setting the foods that birds the can eat. If the food is in the allowedfoods then only it can be be st else
     * else an IllegalArgumentException will be thrown
     * @param foods
     * @throws IllegalArgumentException
     */
    public void setFood(Set<String> foods) throws IllegalArgumentException {
        for (String foodItem : foods) {
            System.out.println(foodItem);
            if (allowedFoods.contains(foodItem.trim().toLowerCase()) && foodItem != null && foodItem != "") {
                food.add(foodItem.trim().toLowerCase());
            } else {
                throw new IllegalArgumentException("Enter a valid Food item");
            }
        }
    }

    /**
     * The Following methods represents some the functionality common to all birds irrespective of what type it is .
     * These method can be overriden based on the specific type of the bird in question
     *
     */

    public String fly() {
        return "Flap flap";
    }

    public String eat(Set<String> food) {
        return "The bird is eating";
    }

    public String chirp() {
        return "chirp chirp";
    }

    public String drink() {
        return "The bird is drinking";
    }

    /**
     * This method provides a human-readable representation of the Bird Object
     * @return
     */
    public String toString() {
        return "Bird{" +
                ", type='" + type + '\'' +
                ", characteristic='" + characteristic + '\'' +
                ", extinct=" + isExtinct +
                ", numOfWings=" + numOfWings +
                ", favoriteFoods=" + food +
                '}';
    }

    /**
     * This method essentially concatenates all the characteristics of the bird into a sting which
     * is returned by the function
     * @return
     */
    @Override
    public String displayCharacteristics() {

//        System.out.println(getCharacteristic());
        String content = "";
        for (int i = 0; i < getCharacteristic().size(); i++) {
            if (i == 0) {
                content = content + characteristic.get(i);
            } else {
                content = content + ". " + characteristic.get(i);
            }

        }

        return content;

    }

    /**
     * This essentially allows to us to compare to bird object in terms of the instance variables they poses.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        Bird b = (Bird)obj;
        if(b.numOfWings == numOfWings && b.getCharacteristic().equals(characteristic) &&
            b.name == name && b.isExtinct == isExtinct && b.getType() == getType() &&
            b.food.equals(food))
        {
            return true;
        }else{
            return false;
        }
    }
}


