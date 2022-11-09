//Read in a list of words from File. Then prompt the user to enter a word to search the list.
// The program reports if the search word is found in the list.

package com.algorithm.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWord<T> {

    ArrayList<T> list = new ArrayList();

    public static <T> void main(String[] args) {

        //Need to create one list of words
        BinarySearchWord bs = new BinarySearchWord();
        bs.list.add("Turtle");
        bs.list.add("Dog");
        bs.list.add("Cat");
        bs.list.add("Tiger");
        bs.list.add("Peacock");
        bs.list.add("Crow");
        bs.list.add("Fish");

        //Convert this list to an array. So that you can perform Binary Search
        T[] words = (T[]) new String[bs.list.size()];
        bs.list.toArray(words);

        //Before performing any searching 1st we need to sort the array
        Arrays.sort(words);

        //Performing one binary search
        System.out.println("Enter the word you want to search in the list");
        Scanner scan = new Scanner(System.in);
        T str = (T) scan.next();
        scan.close();
        int result = binarySearch(words, str);
        if (result == -1)
            System.out.println("Searched word : "+ str +" is not present in the list");
        else
            System.out.println("Searched word : "+ str +" is present in the list at index : "+ result);
    }

    public static <T> int binarySearch(T[] words, T str) {
        int l = 0, r = words.length - 1;
        while (l <= r)
        {
            int mid = l + (r -l) / 2;
            int result = str.toString().compareToIgnoreCase(words[mid].toString());

            //if that word is present at the mid
            if (result == 0)
            {
                return mid;
            }
            //If that is not in mid, check for left half or right half
            if (result > 0)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return -1;      //For default if not getting the word.
    }
}
