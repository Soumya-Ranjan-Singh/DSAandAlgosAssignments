//Take a range of 0 - 1000 Numbers and find the Prime numbers in that range.

package com.algorithm.programs;

public class PrimeNumbers {

    public static void main(String[] args) {

        //Already given the maximum range that is 1000. Lets take n = 1000.
        int n = 1000;

        //Need to check for the prime nos and print those
        System.out.println("Prime nos present in between 0 and 1000 are displayed below");
        for (int i = 0; i <= 1000; i++)
        {
            if (checkPrime(i))
            {
                System.out.print(i + "  ");
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
}
