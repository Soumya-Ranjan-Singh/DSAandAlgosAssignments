//-> One string is an anagram of another if the second is simply a rearrangement of the first.
// For example, 'heart' and 'earth' are anagrams...
//I/P -> Take 2 Strings as Input such abcd and dcba and Check for Anagrams

package com.algorithm.programs;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str1 = scan.nextLine();
        Thread.sleep(1000);
        System.out.println("Enter the second string");
        String str2 = scan.nextLine();
        Thread.sleep(1000);
        scan.close();

        //Check for anagram
        System.out.println(detectAnagram(str1,str2)?
                "Words "+ str1 +" & "+str2+" are Anagram" : "Words "+ str1 +" & "+str2+" are not Anagram");
    }

    //Method for check anagram
    public static boolean detectAnagram(String str1, String str2) {

        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        //If length of both words are not same then they are not anagram.
        boolean status = true;
        if (s1.length() != s2.length())
        {
            status = false;
        }
        else
        {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        return status;
    }
}
