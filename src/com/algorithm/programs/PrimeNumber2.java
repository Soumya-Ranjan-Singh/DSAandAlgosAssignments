//Take a range of 0 - 1000 Numbers and find the Prime numbers in that range.
//Extend the above program to find the prime numbers that are Anagram and Palindrome.

package com.algorithm.programs;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumber2 {

    public static void main(String[] args) {
        //Already given the maximum range that is 1000. Lets take n = 1000.
        int n = 1000;

        //Need to check for the prime nos and to an arraylist so we can further check for anagram and palindrome.
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Prime nos present in between 0 and 1000 are displayed below");
        for (int i = 0; i <= 1000; i++)
        {
            if (checkPrime(i))
            {
                list.add(String.valueOf(i));
            }
        }

        //Convert to an array so that you can check for anagram and palindrome
        String[] arr = new String[list.size()];
        list.toArray(arr);

        //Check for anagram and palindrome and print those prime nos
        String temp;
        for (int i = 0; i < arr.length; i++)
        {
            temp = getPalindrome(arr[i]);
            //Check that palindrome no is present in the array, then go for anagram
            for (int j = 0; j < arr.length; j++)
            {
                if (arr[j].equals(temp))
                {
                    if (detectAnagram(arr[i], temp))
                    {
                        System.out.print(arr[i] + "  ");
                    }
                }
            }
        }
    }

    //Method for checking prime nos
    public static boolean checkPrime(int n) {
        boolean b = true;;
        for(int i = 2; i <= n / 2; i++)
        {
            if (n % i == 0)
            {
                b = false;
                break;
            }
        }
        if(n == 1 || n == 0)
        {
            System.out.println(n + " is Not a Prime Number");
            b = false;
        }
        return b;
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

    //Method for check palindrome
    public static String getPalindrome(String n)
    {
        String r="";
        for (int i = n.length()-1; i >= 0; i--)
        {
            r=r+n.charAt(i);
        }
        if (r.equals(n))
        {
            return r;
        }
        return r;
    }
}
