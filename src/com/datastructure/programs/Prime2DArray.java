//Take a range of 0 - 1000 Numbers and find the Prime numbers in that range. Store
//the prime numbers in a 2D Array, the first dimension represents the range 0-100,
//100-200, and so on. While the second dimension represents the prime numbers in
//that range

package com.datastructure.programs;

public class Prime2DArray {
    public static void main(String[] args) {
        int primeArray[][] = new int[10][100];
        findPrimeInRange(primeArray);
        for(int i=0;i<primeArray.length;i++){
            for(int j=0;j<primeArray[i].length;j++){
                if(primeArray[i][j]!=0)
                    System.out.print(primeArray[i][j]+" ");
            }
            System.out.println();
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
}
