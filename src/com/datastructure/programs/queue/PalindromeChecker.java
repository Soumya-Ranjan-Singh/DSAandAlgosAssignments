//A palindrome is a string that reads the same forward and backward, for
//example, radar, toot, and madam. We would like to construct an algorithm to
//input a string of characters and check whether it is a palindrome.

package com.datastructure.programs.queue;

import java.util.Scanner;

public class PalindromeChecker {

    //Nested class
    static class Queue {
        char data;
        Queue next;

        //Parameterized Constructor
        public Queue(char data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Queue front = null, rear = null;

    // Method to add an key to the queue.
    public void enqueue(char key)
    {
        Queue newNode = new Queue(key);

        if (rear == null)
        {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Method to remove an key from queue.
    public void dequeue()
    {
        if (front == null)
        {
            System.out.println("List is empty");
        }
        else
        {
            if (front != rear)
            {
                front = front.next;
            }
            else
            {
                front = rear = null;
            }
        }
    }

    // Method to peek from queue
    public char peek()
    {
        if (!isEmpty())
        {
            return front.data;
        }
        else
        {
            System.out.println("Stack is empty");
            return ' ';
        }
    }

    // Method to check queue is empty or not
    public boolean isEmpty()
    {
        return front == null;
    }

    public static void main(String[] args) {
        PalindromeChecker queue = new PalindromeChecker();

        System.out.println("Enter a string");
        Scanner scan = new Scanner(System.in);
        String a = scan.next().toLowerCase();
        scan.close();

        //Adding to queue
        for (int i = a.length()-1; i >= 0; i--)
        {
            queue.enqueue(a.charAt(i));
        }

        //Now to dequeue and get it back to a string
        String rev = "";
        while (!queue.isEmpty())
        {
            rev = rev+ queue.peek();
            queue.dequeue();
        }

        if (a.equals(rev))
        {
            System.out.println("The above string : "+a+" is palindrome");
        }
        else
        {
            System.out.println("The above string : "+a+" is not palindrome");
        }
    }
}
