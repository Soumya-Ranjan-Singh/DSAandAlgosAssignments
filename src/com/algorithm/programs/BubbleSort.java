//Reads in integers prints them in sorted order using Bubble Sort.

package com.algorithm.programs;

public class BubbleSort<T> {

    public static void main(String[] args) {
        Integer[] arr = {10, 22, 2, 5, 4, 18, 15, 12, 20, 7};
        System.out.println();
        System.out.println("Before Bubble Sort");
        for (int s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();

        //sorting array using bubble sort
        bubbleSort(arr);

        //Printing the array
        System.out.println("After Bubble Sort");
        for (int s : arr) {
            System.out.print(s + " ");
        }
    }

    //Method for bubble sort
    public static <T extends Comparable> void bubbleSort(T[] arr) {
        T temp;  //Used for swapping
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 1; j < arr.length - i; j++)
            {
                if (arr[j - 1].compareTo(arr[j]) > 0)
                {
                    temp = (T) arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = (T) temp;
                }
            }
        }
    }
}
