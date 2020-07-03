package lambda_streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK", "rabbit", "chiwawa", "OranguTAN", "vipeR", "cobra", "paNDa",
            "bUffalo", "DeeR", "maLLard");

    public static void main(String[] args) {

        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition. 
        lambdaList capsFirst = (animaList, mutate) -> {
            if (mutate) {
                animals = animaList.stream().map(String::toLowerCase)
                        .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                        .collect(Collectors.toList());
                return animals;
            } else {
                return animaList.stream().map(String::toLowerCase)
                        .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                        .collect(Collectors.toList());
            }
        };

        lambdaList lowerFirst = (animaList, mutate) -> {
            if (mutate) {
                animals = animaList.stream().map(String::toUpperCase)
                        .map(name -> name.substring(0, 1).toLowerCase() + name.substring(1))
                        .collect(Collectors.toList());
                return animals;
            } else {
                return animaList.stream().map(String::toUpperCase)
                        .map(name -> name.substring(0, 1).toLowerCase() + name.substring(1))
                        .collect(Collectors.toList());
            }
        };
        //do not modify these addAnimal() method invocations
        lambdaString addAnimal = (animal) -> {
            //add an animal to the animal list.
            Stream<String> concatStream = Stream.concat(animals.stream(), Stream.of(animal));
            animals = concatStream.collect(Collectors.toList());
            return animal;
        };

        lambdaBoolean flipAnimals = (mutate) -> {
            if (mutate) {
                Collections.reverse(animals);
                return animals;
            } else {
                Stream<String> flipStream = animals.stream();
                List<String> flipList = flipStream.collect(Collectors.toList());
                Collections.reverse(flipList);
                return flipList;
            }
        };

        lambdaBoolean sortAnimals = (mutate) -> {
            if (mutate) {
                Collections.sort(animals);
                return animals;
            } else {
                Stream<String> sortStream = animals.stream();
                List<String> sortList = sortStream.collect(Collectors.toList());
                Collections.sort(sortList);
                return sortList;
            }
        };

        System.out.println("Original Animals: " + animals);
        System.out.println("Caps First No Modify: " + capsFirst.returnList(animals, false));
        System.out.println("Animals: " + animals);
        addAnimal.returnString("rEIndeeR");
        addAnimal.returnString("Platypus");
        addAnimal.returnString("frOg");
        addAnimal.returnString("lEOpArD");
        //---------------------------------------
        System.out.println("Caps First Modify: " + capsFirst.returnList(animals, true));
        System.out.println("Lower First No Modify: " + lowerFirst.returnList(animals, false));
        System.out.println("Sort Modify: " + sortAnimals.returnNewList(true));
        System.out.println("Flip No Modify: " + flipAnimals.returnNewList(false));

    }

    interface lambdaList {
        //A method with single parameter
        public List<String> returnList(List<String> animaList, boolean mutate);
    }

    interface lambdaBoolean {
        public List<String> returnNewList(boolean mutate);
    }

    interface lambdaString {
        public String returnString(String animal);
    }

}
