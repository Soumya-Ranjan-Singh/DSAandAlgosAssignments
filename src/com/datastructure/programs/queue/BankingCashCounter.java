//Create a Program which creates Banking Cash Counter where people
//come in to deposit Cash and withdraw Cash. Have an input panel to add people
//to Queue to either deposit or withdraw money and dequeue the people. Maintain
//the Cash Balance.

package com.datastructure.programs.queue;

import com.datastructure.programs.stack.BalancedParentheses;

import java.util.Scanner;

public class BankingCashCounter {

    //Nested class
    static class Queue {
        int data;
        Queue next;

        //Parameterized Constructor
        public Queue(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    Queue front = null, rear = null;

    // Method to add an key to the queue.
    public void enqueue(int key)
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
    public int peek()
    {
        if (!isEmpty())
        {
            return front.data;
        }
        else
        {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // Method to check queue is empty or not
    public boolean isEmpty()
    {
        return front == null;
    }

    public static void main(String[] args) {
        BankingCashCounter queue = new BankingCashCounter();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of persons");
        int person = sc.nextInt();

        int cash = 1000000;

        for (int i = 0; i < person; i++)
        {
            queue.enqueue(i);
        }

        while (!queue.isEmpty())
        {
            System.out.println();
            System.out.println("Cash available " + cash);
            int cnt = 0, ch;

            while (cnt == 0) {
                System.out.println("For serial : "+(queue.peek()+1)+" person"+
                        "\nEnter\n1: Withdraw \n2: Deposit");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println("Enter cash to withdraw");
                        int amount = sc.nextInt();
                        System.out.println("Cash withdrawn successfully");
                        queue.dequeue();
                        cash -= amount;
                        cnt += 1;
                        System.out.println("Remaining cash " + cash);
                        System.out.println("--------THANK YOU VISIT AGAIN-------");
                        break;

                    case 2:
                        System.out.println("Enter the required amount to deposit");
                        int amount1 = sc.nextInt();
                        System.out.println("amount deposited successfully");
                        queue.dequeue();
                        cash = cash + amount1;
                        cnt += 1;
                        System.out.println("Remaining cash " + cash);
                        System.out.println("--------THANK YOU VISIT AGAIN-------");
                        break;

                    default:
                        System.out.println("Invalid input");
                }
            }
        }
    }
}
