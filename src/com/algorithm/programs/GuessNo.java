//Input takes a command-line argument N, asks you to think of a number between 0 and N-1,
// where N = 2^n, and always guesses the answer with n questions.

package com.algorithm.programs;

import java.util.Scanner;

public class GuessNo {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Give the range for N");
        int k = scan.nextInt();
        int n = (int) Math.pow(2,k);
        System.out.println("Power for range is given : " + k +" \nSo the Range is : " + n);
        System.out.println("Think of an integer no that falls in between 0 and " + (n-1));
        int guess = search(0,(n-1));
        System.out.println("The no you have guessed is : " + guess);
        System.out.println("Intermediary numbers is "+(guess-1)+" and "+(guess+1));
    }

    //Method to search and guess the No
    public static int search(int lo, int hi) {
        if (hi - lo == 1)
        {
            System.out.println("Press 1 : If it is higher");
            System.out.println("Press 2 : If it is lower");
            int ch = scan.nextInt();
            if (ch == 1)
                return hi;
            else
                return lo;
        }
        int mid = lo + (hi - lo) / 2;
        System.out.println("Press 1 : If it is falls under "+lo+" - "+mid);
        System.out.println("Press 2 : If it is falls under "+(mid+1)+" - "+hi);
        int choice = scan.nextInt();
        //Number is in first half
        if (choice == 1)
        {
            return search(lo,mid);
        }
        //Number is in second half
        else
        {
            return search(mid + 1, hi);
        }
    }
}
