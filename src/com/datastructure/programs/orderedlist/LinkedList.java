/*Read a List of Numbers from a file and arrange it ascending Order in a
Linked List. Take user input for a number, if found then pop the number out of the
list else insert the number in appropriate position
*/

package com.datastructure.programs.orderedlist;

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
    public <T> void addToLinkedList(T data)
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

    //Adding node after a particular node
    public <T> void addAfterParticularNode(T value)
    {
        Node current = head;
        while (current != null)
        {
            if (!((Integer)value < (Integer) current.next.data))
            {
                current = current.next;
            }
            else if ((Integer)value < (Integer) current.next.data)
            {
                break;
            }
        }
        Node newNode = new Node(value);
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;

    }

    //Sorting the linked list
    public <T> void sortTheLinkedList()
    {
        Node current = head, index = null;
        T temp;
        while (current != null)
        {
            if(head == null)
            {
                return;
            }
            else
            {
                index = current.next;
                while (index != null)
                {
                    if ((Integer)current.data > (Integer) index.data)
                    {
                        temp = (T) current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
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
        addAfterParticularNode(value);
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

        //Creating one unordered array of integer
        Integer[] values = { 10, 14, 28, 11, 7, 16, 30, 50, 25, 18};
        System.out.println("Given array which is going to add to the linked list as it is : \n");
        //Adding to list by means of sorting
        for (int i = 0; i < values.length; i++)
        {
            list.addToLinkedList(values[i]);
            System.out.print(values[i]+ "  ");
        }
        System.out.println();

        //let's sort the linked list
        list.sortTheLinkedList();

        //Printing the list
        list.printLinkedList();

        //Searching for int value which is present
         //Give any present int as input
        list.search();

        //Searching for int value which is not present
        list.search();
    }
    public void search()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter the no you want to search");
        Integer search = scan.nextInt();
        checkNode((T) search);
        printLinkedList();
    }
}
