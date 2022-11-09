//Write a program to do Merge Sort of list of Strings.

package com.algorithm.programs;

public class MergeSort {

    public static void main(String[] args) {
        String[] arr = {"Zeba", "Sambit", "Vikram", "Abinash", "Sandeep", "Biswa", "Chinmay", "Rahul"};
        System.out.println();
        System.out.println("Before Merge Sort");
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();

        //sorting array using merge sort
        int low = 0, high = arr.length - 1;
        mergeSort(arr, low, high);

        //Printing the array
        System.out.println("After Merge Sort");
        for (String s : arr)
        {
            System.out.print(s + " ");
        }
    }

    //Method for merge sort.
    private static <T> void mergeSort(T[] arr, int low, int high) {
        if (low < high)
        {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static <T> void merge(T[] arr, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 = high - mid;

        /* temporary Arrays */
        String LeftArray[] = new String[n1];
        String RightArray[] = new String[n2];

        /* copy data to temp arrays */
        for (i = 0; i < n1; i++)
        {
            LeftArray[i] = (String) arr[low + i];
        }
        for (j = 0; j < n2; j++)
        {
            RightArray[j] = (String) arr[mid + 1 + j];
        }

        i = 0; /* initial index of first sub-array */
        j = 0; /* initial index of second sub-array */
        k = low;  /* initial index of merged sub-array */

        while (i < n1 && j < n2)
        {
            if(LeftArray[i].compareTo(RightArray[j]) < 0)
            {
                arr[k] = (T) LeftArray[i];
                i++;
            }
            else
            {
                arr[k] = (T) RightArray[j];
                j++;
            }
            k++;
        }
        while (i<n1)
        {
            arr[k] = (T) LeftArray[i];
            i++;
            k++;
        }

        while (j<n2)
        {
            arr[k] = (T) RightArray[j];
            j++;
            k++;
        }
    }
}
