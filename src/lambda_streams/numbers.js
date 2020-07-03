//Bonus: refactor Numbers.java into javascript
class Numbers {
    constructor(){
      this.nums =  [10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500];
    }

    isOdd = (i) => {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        console.log("isOdd:");
        const num = this.nums[i].toString().split("");
        if (num[num.length -1] == "1" || num[num.length -1] == "3" || num[num.length -1] == "5"|| num[num.length -1] == "7" || num[num.length -1] == "9" ){
            return true;
        } else {
            return false;
        }
    }

    isEven = (i) => {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        console.log("isEven:");
        const num = this.nums[i].toString().split("");
        if (num[num.length -1] == "0" || num[num.length -1] == "2" || num[num.length -1] == "4"|| num[num.length -1] == "6" || num[num.length -1] == "8" ){
            return true;
        } else {
            return false;
        }
    }

    isPrime = (i) => {
         //determine if the value at the index i is a prime number.  return true if yes, return false if no.
         if(this.nums[i]%2 == 0) return false;
         for(let n=3; n*n<=this.nums[i]; n+=2){
             if(this.nums[i]%n==0)
                 return false;
         }
         return false;
    }

    added = () => {
        //add all the elements in the list.  return the sum.
        console.log("added:");
        const reduced = this.nums.reduce((value, combinedValue) => {
            return combinedValue + value;
        });
        return reduced;
    }

    subtracted = () => {
        //subtract all the elements in the list. return the remainder.
        console.log("subtracted:");
        const reduced = this.nums.reduce((value, combinedValue) => {
            return combinedValue - value;
        });
        return reduced;
    }

    multipled = () => {
        console.log("multipled:");
        const reduced = this.nums.reduce((value, combinedValue) => {
            return combinedValue * value;
        });
        return reduced;
    }

    divided = () => {
        console.log("divided:");
        //multiply all the elements in the list. and return the product.
        const reduced = this.nums.reduce((value, combinedValue) => {
            return value / combinedValue;
        });
        return reduced;
    }

    // int findMax() {
    //     System.out.println("findMax:");
    //     Stream<Integer> numStream = nums.stream();
    //     Optional<Integer> max = numStream.max((val1, val2) => {
    //         return val1.compareTo(val2);
    //     });
    //     return max.get();
    // }

    // int findMin() {
    //     System.out.println("findMin:");
    //     Stream<Integer> numStream = nums.stream();
    //     Optional<Integer> min = numStream.min((val1, val2) -> {
    //         return val1.compareTo(val2);
    //     });
    //     return min.get();
    // }

    compare = (i, j) => {
        console.log("compare:");
        //compare the values stored in the array at index position i and j.
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        if (i > j){return 1;}
        else if (i == j){ return 0;}
        else{return -1;}
    }

    append = (n) => {
        console.log("append:");
        //add a new value to the values list. return that value after adding it to the list.
        console.log("Original array size: " + this.nums.length);

        this.nums = [...this.nums, n];
        console.log("New array size: " + this.nums.length);
        return n;
    }

}

const numbers = new Numbers();
numbers.isOdd(145413);
// numbers.isEven(2138548);
// numbers.added();
// numbers.subtracted();
// numbers.multipled();
// numbers.divided();
// numbers.compare(1,5);
// numbers.append(12);