package environment;

import birds.Bird;

import java.util.*;

public class Conservatory {

    private Set<Aviary> aviarySet = new HashSet<>();
    private Map<String, ArrayList<String>> alphabeticalOrderDictionaryOfBirds = new TreeMap<>();
    private Map<String, Integer> conservatoryFoodReq = new HashMap<>();

    // good
    public Set<Aviary> getAviarySet() {
        return aviarySet;
    }

    // good
    public Map<String, ArrayList<String>> getAlphabeticalOrderDictionaryOfBirds() {
        return alphabeticalOrderDictionaryOfBirds;
    }

    // good
    public Map<String, Integer> getConservatoryFoodReq() {
        return conservatoryFoodReq;
    }

    public Conservatory(Set<Aviary> aviarySet) throws IllegalArgumentException {
        if (aviarySet.size() <= 20 && aviarySet.size() != 0) {
            this.aviarySet = aviarySet;
            sortAlphabetically();
            getFoodReq();
        } else {
            throw new IllegalArgumentException("Please do not add empty aviary or more than 20 Aviaries per conservatory");
        }

    }

    //   GOOD  add new aviary
    public Aviary addAviary(Aviary aviary) throws IllegalStateException {
        if (aviarySet.size() < 20) {
            aviarySet.add(aviary);
            sortAlphabetically();
            getFoodReq();
            return aviary;
        } else {
            throw new IllegalStateException("Cannot add more than 20 aviaries per conservatory");
        }
    }

    // GOOD  add New Aviary without a bird Good by name and loc
    private Aviary addAviary(String name, String location) {
        Aviary aviary = new Aviary(name, location);
        addAviary(aviary);
        return aviary;
    }

    //    GOOD add New avairy with a bird name loc and bird
    public Aviary addAviary(String name, String location, Bird bird) {
        Aviary aviary = addAviary(name, location);
        aviary.addBird(bird);
        addAviary(aviary);
        return aviary;
    }

    //    GOOD
    public Aviary addAviary(String name, String location, List<Bird> birds) {
        Aviary aviary = addAviary(name, location);
        for (Bird bird : birds) {
            aviary.addBird(bird);
        }
        addAviary(aviary);
        return aviary;
    }

    //GOOD
    public List<Aviary> addAviary(List<Aviary> aviaries) {
        for (Aviary aviary : aviaries) {
            addAviary(aviary);
        }
        return aviaries;
    }
    public Boolean addBirdToConservatory(Bird bird) throws IllegalArgumentException, IllegalStateException {
        boolean added = false;
        for (Aviary aviary : aviarySet) {
            if (!added) {
                try {
                    aviary.addBird(bird);
                    added = true;
                    break;
                } catch (IllegalArgumentException | IllegalStateException e) {
                    added = false;
                }
            }
        }
        return added;
    }

    /**
     * This method sorts the birds alphabetically and by using a TreeMap data structure which is able to
     * maintain sorted order in terms of insertion of elements into the map. The elements are sorted based on the Key
     * which in this case is a string. The String Class internally uses a comparator which end up arranging it alphabetically during a sort operation.
     * The method check whether the bird is present in the treemap and if so will add the location of the aviary to which it belongs to into the list of locaitons that it is found.
     * This list serves as the value property of the tree map. If the bird name is not present in the tree, a new key-value pair is created with the key as bird name and value as list fresh list containing
     * the location of the aviary in which it is present
     * @return
     */
    public Map<String, ArrayList<String>> sortAlphabetically() {
        for (Aviary aviary : aviarySet) {
            for (Bird bird : aviary.getBirdList()) {
                if (alphabeticalOrderDictionaryOfBirds.containsKey(bird.getName())) {
                    ArrayList<String> l = alphabeticalOrderDictionaryOfBirds.get(bird.getName());
                    l.add(aviary.getLocation());
                } else {
                    ArrayList<String> l = new ArrayList<String>();
                    l.add(aviary.getLocation());
                    alphabeticalOrderDictionaryOfBirds.put(bird.getName(), l);
                }
            }
        }
        return alphabeticalOrderDictionaryOfBirds;
    }
    public List<Aviary> getAviaryListForBird(Bird bird) {
        List<Aviary> aviariesFound = new ArrayList<>();
        for (Aviary aviary : aviarySet) {
            for (Bird birdInAviary : aviary.getBirdList()) {
                if (bird.equals(birdInAviary)) {
                    aviariesFound.add(aviary);
                }
            }
        }
        return aviariesFound;
    }

    public Map<String, Integer> getFoodReq() {
        for (Aviary aviary : aviarySet) {
            for (Map.Entry<String, Integer> entry : aviary.getAviaryFoodStore().entrySet()) {
                if (conservatoryFoodReq.containsKey(entry.getKey())) {
                    conservatoryFoodReq.put(entry.getKey(), conservatoryFoodReq.get(entry.getKey()) + entry.getValue());
                } else {
                    conservatoryFoodReq.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return conservatoryFoodReq;
    }

    public String aviaryLocBirdInfo() {
        String content = "";
        for (Aviary aviary : aviarySet) {
            content = content + aviary.getName() + " " + aviary.getLocation() + " ";
            for (Bird bird : aviary.getBirdList()) {
                content = content + bird.getName() + " ";
            }
            content = content + "\n";
        }
        return content;
    }

    public String getAviaryInfo(String aviaryName) {
        for (Aviary aviary : aviarySet) {
            if (aviary.getName() == aviaryName) {
                return aviary.Info();
            }
        }
        return "No Aviary with that name present";
    }
}
