//Add the Prime Numbers that are Anagram in the Range of 0 - 1000 in a Stack using
//the Linked List and Print the Anagrams in the Reverse Order. Note no Collection
//Library can be used.

package com.datastructure.programs;

import java.util.Arrays;
import java.util.Stack;

public class Prime2DStack {

    public static void main(String[] args) {
        Stack<String> anagram=new Stack<String>();
        String primeArray[][]=primeAnagramInRange();
        for(int i=0;i<primeArray.length;i++){
            for(int j=0;j<primeArray[i].length;j++){
                if(primeArray[i][j]!=null)
                    anagram.push(primeArray[i][j]);
            }
        }
        while(anagram.size()!=0){
            System.out.println(anagram.pop());
        }
    }

    public static void findPrimeInRange(int[][] primeArray) {

        int no = 2;
        int k = 0;
        for (int i = 0; i < primeArray.length; i++) {
            for (int j = 0; j < primeArray[i].length && no < ((i + 1) * 100); j++) {
                if (isPrime(no)) {
                    primeArray[i][k] = no;
                    k++;
                }
                no++;
            }
            k = 0;
        }

    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        // for checking prime no
        for (int factor = 2; factor * factor <= number; factor++) {
            // if factor divides evenly into n, n is not prime, so break out of loop
            if (number % factor == 0) {
                return false;

            }
        }
        return true;
    }

    public static boolean isAnagram(String string1, String string2) {
        boolean isAnagram = true;
        char[] array1 = string1.toLowerCase().toCharArray();
        char[] array2 = string2.toLowerCase().toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (array1.length != array2.length) {
            return false;
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] == array2[i]) {
                    isAnagram = true;
                } else {
                    isAnagram = false;
                    break;
                }

            }
        }
        return isAnagram;
    }
    public static String[][] primeAnagramInRange() {
        int[][] primeArray = new int[10][100];
        int k = 0;
        String[][] primeAnagram = new String[10][100];
        findPrimeInRange(primeArray);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 99 && primeArray[i][j]!=0; j++) {

                for (int x = j + 1; x < 100&&primeArray[i][x]!=0; x++) {

                    if (isAnagram(String.valueOf(primeArray[i][j]),
                            String.valueOf(primeArray[i][x]))) {
                        primeAnagram[i][k] = String
                                .valueOf(primeArray[i][j]);
                        k++;

                        primeAnagram[i][k] = String
                                .valueOf(primeArray[i][x]);
                        k++;
                    }
                }
            }
            k = 0;
        }
        return primeAnagram;
    }
}
