//Desc -> Take an Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) where parentheses are used to order the
//performance of operations. Ensure parentheses must appear in a balanced fashion.

package com.datastructure.programs.stack;

public class BalancedParentheses {

    //Nested class
    static class Stack {
        int data;
        Stack next;
    }

    Stack top = null;

    //Pushing to stack
    public void push(int value) {
        Stack newNode = new Stack();
        newNode.data = value;
        newNode.next = top;
        top = newNode;
    }

    //Poping from stack
    public void pop() {
        if (top == null)
        {
            return;
        }

        top = top.next;
    }

    //Checking if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        String expression = "(5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3)";
        char[] arr = expression.toCharArray();
        BalancedParentheses obj = new BalancedParentheses();

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[')
            {
                obj.push(i);
            }
            else if (arr[i] == ')' || arr[i] == '}' || arr[i] == ']')
            {
                obj.pop();
            }
        }

        if (obj.isEmpty())
        {
            System.out.println("This above arithmetic expression : "+expression+
                    " is balanced : "+obj.isEmpty());
        }
        else
        {
            System.out.println("This above arithmetic expression : "+expression+
                    " is balanced : "+obj.isEmpty());
        }
    }
}
