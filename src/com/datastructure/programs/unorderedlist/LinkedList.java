/*Read the Text from a file, split it into words and arrange it as Linked List.
Take a user input to search a Word in the List. If the Word is not found then add it
to the list, and if it found then remove the word from the List. In the end save the
list into a file*/

package com.datastructure.programs.unorderedlist;

import java.util.Scanner;

public class LinkedList<T> {

    //Nested class
    static class Node<T>
    {
        T data;
        Node next;
        Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;
    static int position;

    //Adding to linked list.
    public void addToLinkedList(T data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.next = null;
        }
        tail = newNode;
    }

    //Search the LinkedList to find a particular node
    public void checkNode(T value)
    {
        Node current = head;
        int count = 1;
        while (current != null)
        {
            if (current.data.equals(value))
            {
                System.out.println("Searched key : "+value+" is present at node : "+count);
                position = count;
                System.out.println("Removing that key : "+value+" from the Linked List");
                popNodeAtAGivenIndex(position);
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println("Searched key "+value+" is not present in the LinkedList");
        addToLinkedList(value);
    }

    //Delete the first element in the linked list
    public void pop()
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }
        else
        {
            if (head != tail)
            {
                head = head.next;
            }
            else
            {
                head = tail = null;
            }
        }
    }

    //Delete last element in the linked list
    public void popLast()
    {
        if (head == null)
        {
            System.out.println("List is empty");
        }
        else
        {
            if (head != tail)
            {
                Node current = head;
                while (current.next.next != null)
                {
                    current = current.next;
                }
                tail = current;
                tail.next = null;
            }
            else
            {
                head = tail = null;
            }
        }
    }

    //Delete node at given index.
    public void popNodeAtAGivenIndex(int index) {

        //case when we need to remove the head node
        if (index == 1)
        {
            pop();
        }
        else if (index == getLinkedListSize())
        {
            //case when we need to remove the tail node
            popLast();
        }
        else
        {
            int count = 1;
            Node current = head;
            while (current != null && count != index -1)
            {
                current = current.next;
                count++;
            }
            current.next = current.next.next;
        }
    }

    //Getting linked list size
    public int getLinkedListSize()
    {
        Node current = head;
        int count = 0;
        while (current != null) {

            current = current.next;
            count++;
        }
        return count;
    }

    //Print LinkedList
    public void printLinkedList()
    {
        Node current = head;
        if (head == null)
        {
            System.out.println("LinkedList is empty");
            return;
        }
        while (current != null)
        {
            System.out.print(current.data+"  ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.println("Welcome to LinkedList program");
        String textFile = "I am Soumya Singh"; //Giving text
        String[] words = textFile.split(" ");

        //Adding to linked list
        for (String word : words)
        {
            list.addToLinkedList(word);
        }

        //Printing the linked list
        list.printLinkedList();

        //Searching for Singh (It is present in the linked list.)
        System.out.println();
        System.out.println("Enter the string you want to search");
        Scanner scan = new Scanner(System.in);
        String search1 = scan.next(); //Give Singh as input
        list.checkNode(search1);
        list.printLinkedList();

        //Searching for Ranjan (That is not present in linked list)
        System.out.println();
        System.out.println("Enter the string you want to search");
        String search2 = scan.next(); //Give Ranjan as input
        scan.close();
        list.checkNode(search2);
        list.printLinkedList();
    }
}
