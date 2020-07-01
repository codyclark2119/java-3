package lambda_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);
    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wheever possible.
        System.out.println(isOdd(1));
        System.out.println(isEven(494));
        System.out.println(added());
        System.out.println(subtracted());
        System.out.println(multipled());
        System.out.println(divided());
        System.out.println(findMax());
        System.out.println(findMin());
        System.out.println(compare(1,0));
        System.out.println(append(12));
        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls, or defined them first, then pass them into the methods. give them the same names as the static methods, but add the word 'lambda' in front of every lambda function:
        /* e.g.

        added(() -> {});

        OR

        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});

        OR

        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...

        */

    }

    static boolean isOdd(int i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        System.out.println("isOdd:");
        String[] num = Integer.toString(i).split("");
        if (num[num.length -1].equals("1") || num[num.length -1].equals("3") || num[num.length -1].equals("5")|| num[num.length -1].equals("7") || num[num.length -1].equals("9") ){
            return true;
        } else {
            return false;
        }
    }

    static boolean isEven(int i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        System.out.println("isEven:");
        String[] num = Integer.toString(i).split("");
        if (num[num.length -1].equals("0") || num[num.length -1].equals("2") || num[num.length -1].equals("4")|| num[num.length -1].equals("6") || num[num.length -1].equals("8") ){
            return true;
        } else {
            return false;
        }
    }

    static boolean isPrime(int i) {
         //determine if the value at the index i is a prime number.  return true if yes, return false if no.
         return false;
    }

    static int added() {
        //add all the elements in the list.  return the sum.
        System.out.println("added:");
        Stream<Integer> numStream = nums.stream();
        Optional<Integer> reduced = numStream.reduce((value, combinedValue) -> {
            return combinedValue + value;
        });
        return reduced.get();
    }

    static int subtracted() {
        //subtract all the elements in the list. return the remainder.
        System.out.println("subtracted:");
        Stream<Integer> numStream = nums.stream();
        Optional<Integer> reduced = numStream.reduce((value, combinedValue) -> {
            return combinedValue - value;
        });
        return reduced.get();
    }

    static Long multipled() {
        System.out.println("multipled:");
        List<Long> longNums = nums.stream()
                .mapToLong(Integer::longValue)
                .boxed()
                .collect(Collectors.toList());
        Stream<Long> numStream = longNums.stream();
        Optional<Long> reduced = numStream.reduce((value, combinedValue) -> {
            return combinedValue * value;
        });
        return reduced.get();
    }

    static Double divided() {
        System.out.println("divided:");
        //multiply all the elements in the list. and return the product.
        List<Double> dubNums = nums.stream()
                .mapToDouble(Integer::doubleValue)
                .boxed()
                .collect(Collectors.toList());
        Stream<Double> numStream = dubNums.stream();
        Optional<Double> reduced = numStream.reduce((value, combinedValue) -> {
            return value / combinedValue;
        });
        return reduced.get();
    }

    static int findMax() {
        System.out.println("findMax:");
        Stream<Integer> numStream = nums.stream();
        Optional<Integer> max = numStream.max((val1, val2) -> {
            return val1.compareTo(val2);
        });
        return max.get();
    }

    static int findMin() {
        System.out.println("findMin:");
        Stream<Integer> numStream = nums.stream();
        Optional<Integer> min = numStream.min((val1, val2) -> {
            return val1.compareTo(val2);
        });
        return min.get();
    }

    static int compare(int i, int j) {
        System.out.println("compare:");
        //compare the values stored in the array at index position i and j.  
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        if (i > j){return 1;}
        else if (i == j){ return 0;}
        else{return -1;}
    }

    static int append(int n) {
        System.out.println("append:");
        //add a new value to the values list. return that value after adding it to the list.
        System.out.println("Original array size: " +nums.size());
        Stream<Integer> numStream = nums.stream();
        Stream<Integer> addStream = Stream.of(n);

        Stream<Integer> concatStream = Stream.concat(numStream, addStream);

        List<Integer> newNums = concatStream
                .collect(Collectors.toList());
        nums = newNums;
        System.out.println("New array size: " + nums.size());
        return n;
    }

}
