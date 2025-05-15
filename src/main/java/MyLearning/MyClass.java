package MyLearning;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {

    public int recursiveFactorial(int num)
    {
        if (num == 0 || num == 1) return 1;
        else return num * recursiveFactorial(num-1);
    }

    //0 1 1 2 3 5 8 13
    public int recursiveFibonacciSeries(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
         return recursiveFibonacciSeries(n - 1) + recursiveFibonacciSeries(n - 2);
    }

    //reverse string
    public String reverse(String name){
        if (name.length() <= 1 | name == null) {
            return name;
        }else {
            return reverse(name.substring(1)) + name.charAt(0);
        }
    }

    public int sumNaturalNumber(int num){
        if (num == 1) {
            return 1;
        }
        return num + sumNaturalNumber(num - 1);
    }

    public boolean palindrome(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return palindrome(str, left + 1, right -1);
    }

    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        //int val = myClass.recursiveFactorial(5);
        //int val = myClass.recursiveFactorial(5);
        //String val = myClass.reverse("Hello");
        //int val = myClass.sumNaturalNumber(5);
        boolean val = myClass.palindrome("madam", 0, 4);
        System.out.println(val);

        //myClass.fibonacci();

        //List<Integer> nums = Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6);

        //Print array values
        //nums.stream().forEach(n -> System.out.println(n));
/*        List<String> values = Arrays.asList("apple", "banana", "kiwi", "grape");
        List<String> sorted_values = values.stream().sorted((a,b)->Integer.compare(a.length(),b.length())).collect(Collectors.toList());
        System.out.println(sorted_values);*/

//-------------------------------------------------------------------------------------------------------------
//        Problem: Given a list of integers, write a Java function that filters and returns only the even numbers using a lambda expression.
//        Example:
//        Input: [1, 2, 3, 4, 5, 6]
//        Output: [2, 4, 6]

//        Solution: 1 - with stream API
/*        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> even_nums = nums.stream().filter(n -> n%2==0).collect(Collectors.toList());
        System.out.println(even_nums);*/

//        Solution: 2 - without stream API
/*        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        for (int num : numbers){
            if (num % 2 == 0) {
                System.out.print(num+ " ");
            }
        }*/
//-------------------------------------------------------------------------------------------------------------

        //Sort Strings by Length
        //Problem:
        //Given a list of strings, sort the strings by their length using a lambda expression.
        //Example:
        //Input: ["apple", "banana", "kiwi", "grape"]
        //Output: ["kiwi", "apple", "grape", "banana"]

        //Solution: 1
/*        List<String> values = Arrays.asList("apple", "banana", "kiwi", "grape");
        List<String> sortedString = values.stream().sorted((a,b)->Integer.compare(a.length(), b.length()))
                        .collect(Collectors.toList());
        System.out.println(sortedString);*/

        //Solution - 2

/*        String[] fruits = {"apple", "banana", "kiwi", "grape"};
        for (int i =0; i< fruits.length; i++){
            for(int j=i+1; j< fruits.length; j++){
                if (fruits[i].length() > fruits[j].length()){
                    String firstValue = fruits[i];
                    fruits[i]=fruits[j];
                    fruits[j]=firstValue;
                }
            }
        }
        for (String fruit:fruits) {
            System.out.print(fruit+ " ");
        }*/
//-------------------------------------------------------------------------------------------------------------
//        Sum of Numbers Greater Than 10
//        Problem: Given a list of integers, calculate the sum of all the numbers greater than 10 using a lambda expression.
//        Example:
//        Input: [5, 12, 8, 15, 3, 18]
//        Output: 45
//
//        Solution: 1
//        List<Integer> nums = Arrays.asList(5, 12, 8, 15, 3, 18);
//        int sum = nums.stream().filter(n->n>10).mapToInt(n->n).sum();
//        System.out.println(sum);

//        Solution: 2
/*        int total=0;
        Integer[] numbers = {5, 12, 8, 15, 3, 18};
        for (int num : numbers) {
            if (num > 10) {
                total = total + num;
            }
        }
        System.out.println(total);*/
//-------------------------------------------------------------------------------------------------------------

/*      Square of Numbers
        Example:
        Input: [1, 2, 3, 4, 5]
        Output: [1, 4, 9, 16, 25]*/
/*        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> values = nums.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println(values);*/

//        Solution 2
/*        Integer[] number = {1, 2, 3, 4, 5};
        for (int num:number)
            System.out.print(num * num+ " ");*/
//-------------------------------------------------------------------------------------------------------------
/*        Count Strings Starting with a Specific Character
        Problem: Given a list of strings, count how many strings start with the letter 'A' using a lambda expression.
        Example:
        Input: ["Apple", "Banana", "Avocado", "Cherry"]
        Output: 2*/
/*        List<String> values = Arrays.asList("Apple", "Banana", "Avocado", "Cherry");
        long count = values.stream().filter(n-> n.startsWith("A")).count();
        System.out.println(count);*/
//-------------------------------------------------------------------------------------------------------------
/*        Find Average of Numbers Greater Than a Threshold
        Problem: Given a list of integers, calculate the average of numbers greater than a threshold value (e.g., 10) using a lambda expression.
        Example:
        Input: [5, 12, 8, 15, 3, 18] and threshold = 10
        Output: 15.0*/
/*
        List<Integer> nums = Arrays.asList(5, 12, 8, 15, 3, 18);
        OptionalDouble sum = nums.stream().filter(n-> n>10).mapToInt(n->n).average();
        System.out.println(sum.getAsDouble());*/
//-------------------------------------------------------------------------------------------------------------
/*        Convert List of Strings to Uppercase
        Problem: Given a list of strings, convert each string to uppercase using a lambda expression.
        Example:
        Input: ["apple", "banana", "cherry"]
        Output: ["APPLE", "BANANA", "CHERRY"]*/

        //Solution:
/*        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
        List<String> newFruits = fruits.stream().map(n->n.toUpperCase()).collect(Collectors.toList());
        System.out.println(newFruits);*/
//-------------------------------------------------------------------------------------------------------------
//        Remove Duplicates from a List
//        Problem: Given a list of integers, remove the duplicates and return the unique values using a lambda expression.
//        Example:
//        Input: [1, 2, 2, 3, 4, 4, 5]
//        Output: [1, 2, 3, 4, 5]

//            List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
//            List<Integer> values = nums.stream().distinct().collect(Collectors.toList());
//            System.out.println(values);
//-------------------------------------------------------------------------------------------------------------
//        Group Words by Length
//        Problem: Given a list of words, group them by their length using a lambda expression.
//        Example:
//        Input: ["apple", "banana", "kiwi", "grape", "pear"]
//        Output: {5: ['apple', 'grape', 'pear'], 6: ['banana'], 4: ['kiwi']}
//
//        Solution:
/*        List<String> fruits = Arrays.asList("apple", "banana", "kiwi", "grape", "pear");
        Map<Integer, List<String>> groupFruits = fruits.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupFruits);*/

/*        String name = "ABCABCABCABCCCC";
        char[] my = name.toCharArray();
        int myArraySize = my.length;
        for (int i = 0; i< myArraySize; i++) {
            int count = 0;
            for (int j =i+1; j< myArraySize; j++){
                if (my[i]==my[j])
                {
                    count ++;
                    myArraySize --;
                    for (int k =j;k < myArraySize; k++){
                        my[k] = my[k+1];
                    }
                    j--;
                 }
            }
            System.out.println(my[i] + " Repeated "+count+ " times");
        }
        for (int a = 0; a< myArraySize; a++) {
            System.out.print(my[a]);
        }*/

        //Reverse a String
        /*String name = "ABCDEFGHIJKLM";
        char[] name_array = name.toCharArray();
        int lastIndex = name_array.length - 1;
        for (int i = lastIndex; i >=0; i--)
        {
            System.out.print(name_array[i]);
        }*/

        //Check if a Number is Prime

/*        boolean status = false;
        int number = 11;
        if (number > 1) {
            for (int i=2;i<Math.sqrt(number); i++) {
                if (number % i == 0)
                    status =false;
                else
                    status=true;
            }
        }else {
            System.out.println("This is not a prime number");
        }
        System.out.println("Status is "+status);*/
    }
}