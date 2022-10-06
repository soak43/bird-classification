package birds;

import birds.Bird.Type;

import java.util.*;

public class Aviary {

    String name;
    List<Bird> birdList = new ArrayList<>();
    Set<Type> birdTypeSet = new HashSet<>();

    String location;
    final int MAX_BIRDS_IN_AVIARY = 5;

    public Aviary(String name, String location) throws IllegalArgumentException{
        if(name.trim() == "" || location.trim()  == ""){
            throw new IllegalArgumentException("Enter a valid location or name");
        }else{
            this.name = name;
            this.location = location;
        }
    }
    public Aviary(String name, String location, Bird bird){
        this(name,location);
        addBird(bird);
    }
    public Aviary(String name, String location, List<Bird> userBirdList) {
        this(name,location);
        for(Bird b : userBirdList){
            addBird(b);
        }
    }
    private String generateBirdInfo(Bird bird){
        String content = "The Bird's name is " + bird.getName() + ". Some of the interesting characteristics of this bird are as follows \n" + bird.displayCharacteristics();
        return content;
    }

    private String avaiaryInfo(){
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

    public Aviary(List<Bird> birdList) {

    }

    public Bird addBird(Bird bird) throws IllegalArgumentException,IllegalStateException {
        //constraint
//        num b < 5 done
//        bird cannot be extinct done
//        bird type done

        if (!bird.isExtinct()) {
            if (birdList.isEmpty()) {
                birdList.add(bird);
                birdTypeSet.add(bird.getType());

            } else if (birdList.size() <= MAX_BIRDS_IN_AVIARY) {
                if(bird.getType() == Type.BIRDS_OF_PREY || bird.getType() == Type.FLIGHTLESS_BIRDS || bird.getType() == Type.WATERFOWL ){
                    if (birdTypeSet.contains(Type.BIRDS_OF_PREY) && birdTypeSet.size() == 1 && bird.getType() == Type.BIRDS_OF_PREY) {
                        birdList.add(bird);
                    } else if (birdTypeSet.contains(Type.FLIGHTLESS_BIRDS) && birdTypeSet.size() == 1 && bird.getType() == Type.FLIGHTLESS_BIRDS) {
                        birdList.add(bird);
                    } else if (birdTypeSet.contains(Type.WATERFOWL) && birdTypeSet.size() == 1 && bird.getType() == Type.WATERFOWL) {
                        birdList.add(bird);
                    } else {
                        throw new IllegalArgumentException("Cannot add other types to an aviary containing " + bird.getType());
                    }
                }else {
                    birdList.add(bird);
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
            }
            return birdList;
        }
        return null;
    }
//    private int birdCount;
//    private List<Bird> birdList = new ArrayList<Bird>();
//    private char flag = Character.MIN_VALUE;
//
//    private Set<String> characteristicList = new HashSet<String>();
//
//
//    public void addBird(Bird b) throws IllegalArgumentException{
//
//        if(birdCount < 5){
//            if(b.isExtinct() == true){
//                throw new IllegalArgumentException("The bird is extinct. Cannot add it to the aviary");
//            }
//            //check is the birds in the aviary are not waterfowls, birdsofprey or flightless birds
//            //char flag = w (waterfowl), p (birdsofprey), f (flightless bird)
//
//            if(birdCount==0){
//                birdList.add(b);
//                if(b.getType() == Bird.Type.BIRDS_OF_PREY){
//                    flag = 'p';
//                } else if (b.getType() == Bird.Type.FLIGHTLESS_BIRDS) {
//                    flag = 'f';
//                } else if (b.getType() == Bird.Type.WATERFOWL){
//                    flag = 'w';
//                }
//            }
//            else{
//                if(flag == Character.MIN_VALUE){
//                    birdList.add(b);
//                }
//                else
//                {
//                    if(b.getType() == Bird.Type.BIRDS_OF_PREY && flag == 'p'){
//                        birdList.add(b);
//                    } else if (b.getType() == Bird.Type.FLIGHTLESS_BIRDS && flag == 'f') {
//                        birdList.add(b);
//                    } else if (b.getType() == Bird.Type.WATERFOWL && flag == 'w'){
//                        birdList.add(b);
//                    }
//                    else{
//                        throw new IllegalArgumentException("The birds in this aviary cannot be mixed with other birds");
//                    }
//                }
//            }
//            birdList.add(b);
//        }
//        else{
//            throw new IllegalArgumentException("Aviary is full");
//        }

//    }

//    public void removeBird(Bird b) throws IllegalArgumentException{
//
//        if(birdCount!=0){
//            if(birdList.contains(b)){
//                birdList.remove(b);
//            }
//            else{
//                throw new IllegalArgumentException("Aviary does not have the bird you want to remove");
//            }
//        }
//        else{
//            throw new IllegalArgumentException("Aviary is empty");
//        }
//    }
}
