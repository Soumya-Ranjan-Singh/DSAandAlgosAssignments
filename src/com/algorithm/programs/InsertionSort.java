//Reads in strings and prints them in sorted order using insertion sort.

package com.algorithm.programs;

public class InsertionSort<T> {

    public static void main(String[] args) {

        String[] arr = {"Zeba", "Sambit", "Vikram", "Abinash", "Sandeep", "Biswa", "Chinmay", "Rahul"};
        System.out.println();
        System.out.println("Before Insertion Sort");
        for (String s : arr)
        {
            System.out.print(s + " ");
        }
        System.out.println();

        //sorting array using insertion sort
        insertionSort(arr);

        //Printing the array
        System.out.println("After Insertion Sort");
        for (String s : arr)
        {
            System.out.print(s + " ");
        }
    }

    //Method for insertion sort.
    public static <T extends Comparable> void insertionSort(T[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++)
        {
            T key = arr[i];
            int j = i - 1;
            while ( (j > -1) && arr[j].compareTo(key) > 0)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
