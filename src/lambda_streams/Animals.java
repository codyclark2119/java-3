package lambda_streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Animals {
    //This class will be using streams.
    static List<String> animals = Arrays.asList("peacoCK","rabbit","chiwawa","OranguTAN","vipeR","cobra","paNDa","bUffalo","DeeR","maLLard");

    public static void main(String[] args) {
        System.out.println("original animals : " + animals);

        //clean up the animals array by using the capsFirst() method. follow instructions in the method definition. 
        List<String> cleaned = capsFirst(animals, false);
        System.out.println(cleaned);
       
        //do not modify these addAnimal() method invocations
        addAnimal("rEIndeeR");
        addAnimal("Platypus");
        addAnimal("frOg");
        addAnimal("lEOpArD");
        //---------------------------------------

        capsFirst(animals,true);
        System.out.println(animals);

        List<String> lowered = lowerFirst(animals,false);
        System.out.println(lowered);
        System.out.println(sortAnimals(true));
        System.out.println(flipAnimals(false));

    }

    static List<String> capsFirst(List<String> animaList, boolean mutate) {
        //clean up the animals list so that the first letter is capitalized, and all the other letters are lowercased. Use a stream to accomplish this task.  Also, the 2nd parameter of this function is a boolean.  use this boolean 'flag' to determine whether or not to 'mutate' the original animals array stored as a static class field.  if the flag is set to 'true', mutate the animals and return the animals out of the function.  if it is false, create a copy of the animals, perform your stream operations on the copy, and return the copy of animals out of the function, WITHOUT modifying the original animals array.  
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
    }

    static String addAnimal(String animal) {
        //add an animal to the animal list.
        Stream<String> concatStream = Stream.concat(animals.stream(), Stream.of(animal));
        animals = concatStream.collect(Collectors.toList());
        return animal;
    };


    static List<String> lowerFirst(List<String> animaList, boolean mutate) {
        //lowercase the first letter, and uppercase the rest of the letters, using streams.  Also, depending on the value of the boolean flag 'mutate', mutate the original animals list, or perform your stream operations on a 'copy' of the animals list.  return the list out of hte function in both cases.
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
    }

    static List<String> flipAnimals(boolean mutate) {
        //reverse the order of the animals in the animal list.  If the booleaen parameter is true, reverse the static animals array list by mutating the array.  if the mutate boolean is false, flip a 'copy' of the animals list, then return that list of flipped animals, WITHOUT mutating the static animals array. return the flipped list in both cases.
        List<String> instructions = Arrays.asList("Flip","the","animals","list","."," ","Mutate","the","animals","only","if","flag","true");
        if (mutate) {
            Collections.reverse(animals);
            return animals;
        } else {
            Stream<String> flipStream = animals.stream();
            List<String> flipList = flipStream.collect(Collectors.toList());
            Collections.reverse(flipList);
            return flipList;
        }

    }

    static List<String> sortAnimals(boolean mutate) {
    //sort the animals in alphabetical order.  If the booleaen parameter is true, mutating the animals list.  if the mutate boolean is false, sort a 'copy' of the animals list, then return that list of sorted animals, WITHOUT mutating the static animals array. return the sorted list in both cases.
        if (mutate) {
            Collections.sort(animals);
            return animals;
        } else {
            Stream<String> sortStream = animals.stream();
            List<String> sortList = sortStream.collect(Collectors.toList());
            Collections.sort(sortList);
            return sortList;
        }

    }


}
