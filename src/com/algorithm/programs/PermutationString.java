//Write static functions to return all permutations of a String using iterative method and Recursion method.
// Check if the arrays returned by two string functions are equal.

package com.algorithm.programs;

import java.util.Scanner;

public class PermutationString {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter the string you want to permute");
        String str = scan.next().toUpperCase();
        scan.close();
        System.out.println("Given string is : "+str);
        int length = str.length();
        int start = 0;
        System.out.println("All the permutations of the string are : ");

        //For recursive
        System.out.println("Generating permutations recursively");
        generateRecursivePermutation(str, start, length);

        //For iterative
        System.out.println("\nGenerating permutations iteratively");
        String ans = ""; //Needing a separate variable to store (kind of null variable).
        generateIterativePermutation(str,ans);
    }

    //Method for generating different permutations of the string by means of recursion
    public static void generateRecursivePermutation(String str, int start, int end)
    {
        //Prints the permutations
        if (start == end-1)
            System.out.print(str + "  ");
        else
        {
            for (int i = start; i < end; i++)
            {
                //Swapping the string by fixing a character
                str = swapString(str,start,i);
                //Recursively calling function generateRecursivePermutation() for rest of the characters
                generateRecursivePermutation(str,start+1,end);
                //Backtracking and swapping the characters again.
                str = swapString(str,start,i);
            }
        }
    }
    public static String swapString(String a, int i, int j) {
        char[] b =a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }

    //Method for generating different permutations of the string by means of iteration
    public static void generateIterativePermutation(String str, String ans) {
        if (str.length() == 0)
        {
            System.out.print(ans + "  ");
            return;
        }

        //Iteratively calling the function and adding values to the null string that is "ans";
        int i = 0;
        while (i < str.length())
        {
            char ch = str.charAt(i);
            String left_substr = str.substring(0, i);
            String right_substr = str.substring(i + 1);
            String rest = left_substr + right_substr;
            generateIterativePermutation(rest, ans + ch);
            i++;
        }
    }
}
