package lambda_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Numbers {
    static List<Integer> nums = Arrays.asList(10, 100, 1000, 5, 50, 500, 3, 30, 300, 7, 70, 700, 1, 10, 100, 25, 250,
            2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wheever possible.
        lambdaBoolean isOdd = (i) -> {
            //determine if the value at the index i is odd.  return true if yes, return false if  no.
            System.out.println("isOdd:");
            Integer num = nums.get(i);
            String[] numArr = Integer.toString(num).split("");
            if (numArr[numArr.length - 1].equals("1") || numArr[numArr.length - 1].equals("3")
                    || numArr[numArr.length - 1].equals("5") || numArr[numArr.length - 1].equals("7")
                    || numArr[numArr.length - 1].equals("9")) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println(isOdd.returnBoolean(0));

        lambdaBoolean isEven = (i) -> {
            //determine if the value at the index i is even.  return true if yes, return false if  no.
            System.out.println("isEven:");
            Integer num = nums.get(i);
            String[] numArr = Integer.toString(num).split("");
            if (numArr[numArr.length - 1].equals("0") || numArr[numArr.length - 1].equals("2")
                    || numArr[numArr.length - 1].equals("4") || numArr[numArr.length - 1].equals("6")
                    || numArr[numArr.length - 1].equals("8")) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println(isEven.returnBoolean(2));

        lambdaBoolean isPrime = (i) -> {
            //determine if the value at the index i is a prime number.  return true if yes, return false if no.
            System.out.println("isPrime:");
            Integer num = nums.get(i);
            if (num % 2 == 0)
                return false;
            for (int n = 3; n * n <= num; n += 2) {
                if (num % n == 0)
                    return false;
            }
            return true;
        };
        System.out.println(isPrime.returnBoolean(0));

        lambdaInt added = () -> {
            //add all the elements in the list.  return the sum.
            System.out.println("added:");
            Stream<Integer> numStream = nums.stream();
            Optional<Integer> reduced = numStream.reduce((value, combinedValue) -> {
                return combinedValue + value;
            });
            return reduced.get();
        };
        System.out.println(added.returnInt());

        lambdaInt subtracted = () -> {
            //subtract all the elements in the list. return the remainder.
            System.out.println("subtracted:");
            Stream<Integer> numStream = nums.stream();
            Optional<Integer> reduced = numStream.reduce((value, combinedValue) -> {
                return combinedValue - value;
            });
            return reduced.get();
        };
        System.out.println(subtracted.returnInt());

        lambdaLong multipled = () -> {
            System.out.println("multipled:");
            List<Long> longNums = nums.stream().mapToLong(Integer::longValue).boxed().collect(Collectors.toList());
            Stream<Long> numStream = longNums.stream();
            Optional<Long> reduced = numStream.reduce((value, combinedValue) -> {
                return combinedValue * value;
            });
            return reduced.get();
        };
        System.out.println(multipled.returnLong());

        lambdaDouble divided = () -> {
            System.out.println("divided:");
            //multiply all the elements in the list. and return the product.
            List<Double> dubNums = nums.stream().mapToDouble(Integer::doubleValue).boxed().collect(Collectors.toList());
            Stream<Double> numStream = dubNums.stream();
            Optional<Double> reduced = numStream.reduce((value, combinedValue) -> {
                return value / combinedValue;
            });
            return reduced.get();
        };
        System.out.println(divided.returnDouble());

        lambdaInt findMax = () -> {
            System.out.println("findMax:");
            Stream<Integer> numStream = nums.stream();
            Optional<Integer> max = numStream.max((val1, val2) -> {
                return val1.compareTo(val2);
            });
            return max.get();
        };
        System.out.println(findMax.returnInt());

        lambdaInt findMin = () -> {
            System.out.println("findMin:");
            Stream<Integer> numStream = nums.stream();
            Optional<Integer> min = numStream.min((val1, val2) -> {
                return val1.compareTo(val2);
            });
            return min.get();
        };
        System.out.println(findMin.returnInt());

        lambdaCompare compare = (i, j) -> {
            System.out.println("compare:");
            //compare the values stored in the array at index position i and j.  
            //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
            if (i > j) {
                return 1;
            } else if (i == j) {
                return 0;
            } else {
                return -1;
            }
        };
        System.out.println(compare.returnCompare(1, 0));

        lambdaAppend append = (i) -> {
            System.out.println("append:");
            //add a new value to the values list. return that value after adding it to the list.
            System.out.println("Original array size: " + nums.size());

            Stream<Integer> concatStream = Stream.concat(nums.stream(), Stream.of(i));

            List<Integer> newNums = concatStream.collect(Collectors.toList());
            nums = newNums;
            System.out.println("New array size: " + nums.size());
            return i;
        };
        System.out.println(append.returnAppend(12));

    }

    interface lambdaBoolean {
        //A method with single parameter
        public boolean returnBoolean(int i);
    }

    interface lambdaInt {
        //A method with single parameter
        public int returnInt();
    }

    interface lambdaLong {
        public long returnLong();
    }

    interface lambdaDouble {
        public double returnDouble();
    }

    interface lambdaCompare {
        public int returnCompare(int i, int j);
    }

    interface lambdaAppend {
        public int returnAppend(int i);
    }
}
