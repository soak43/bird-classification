package birds;

import java.util.*;

public class Bird extends Animalia {

    public enum Type {
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

    public final static Set<String> allowedFoods = new HashSet<>(Arrays.asList(
            "berries", "seeds", "fruits", "insects", "other birds", "eggs", "small mammals", "fish", "buds", "larvae", "aquatic invertebrates", "nuts", "vegetation"
    ));

    private Set<String> food = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == "" || name == null) {
            throw new IllegalArgumentException("Enter a valid name");
        } else {
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
        if (numOfWings == 0 || numOfWings == 2) {
            this.numOfWings = numOfWings;
        } else {
            throw new IllegalArgumentException("Wings have to be 0 or 2.");
        }
    }

    public boolean isExtinct() {
        return isExtinct;
    }

    public void setExtinct(boolean extinct) {
        isExtinct = extinct;
    }

    public Set<String> getFood() {
        return food;
    }

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
        content += ".";
        return content;

    }
}


