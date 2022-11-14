//Create a Slot of 10 to store Chain of Numbers that belong to each Slot to efficiently search a number from a given set of number

package com.datastructure.programs;

import java.util.*;

public class HashingFunction {

    static class NumDetails
    {
        private int no;

        public NumDetails(int data)
        {
            setNo(data);
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "NumDetails{" +
                    "no=" + no +
                    '}';
        }
    }

    static class AddList
    {
        List<NumDetails> numDetailsList;
        public AddList() {
            this.numDetailsList = new ArrayList<>();
        }

        public void addNumberList(int data)
        {
            numDetailsList.add(addNumber(data));
        }

        public NumDetails addNumber(int data)
        {
            NumDetails obj = new NumDetails(data);
            return obj;
        }

        public NumDetails check(int data)
        {
            for(NumDetails temp : numDetailsList) {

                if(temp.getNo() == data)
                {
                    return temp;
                }
            }
            return null;
        }

        public void deleteNum(int data) {
            for(NumDetails temp : numDetailsList)
            {
                if(temp.getNo() == data)
                {
                    numDetailsList.remove(temp);
                }
            }
        }

        @Override
        public String toString() {
            return "AddList{" +
                    "numDetailsList=" + numDetailsList +
                    '}';
        }
    }

    static Map<Integer, AddList> hashingMap = new HashMap<>();

    public static void main(String[] args) {

        boolean flag = true;
        while (flag)
        {
            AddList addList = new AddList();
            System.out.println("Enter a num");
            Scanner scan = new Scanner(System.in);
            int no = scan.nextInt();
            int rem = no % 11;
            addList.addNumberList(no);
            switch (rem)
            {
                case 0 :
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                case 9 :
                case 10 :
                    if (hashingMap.get(rem) == null)
                    {
                        hashingMap.put(rem, addList);
                    }
                    else
                    {
                        Iterator<Map.Entry<Integer, AddList>> itr = hashingMap.entrySet().iterator();
                        boolean get = false;
                        while (itr.hasNext())
                        {
                            Map.Entry<Integer, AddList> entry = itr.next();
                            if (entry.getValue().check(no) != null)
                            {
                                get = true;
                                break;
                            }
                        }
                        if (get == false)
                        {
                            hashingMap.get(rem).addNumberList(no);
                        }
                        else
                        {
                            hashingMap.get(rem).deleteNum(no);
                        }
                    }
                    break;
                default :
                    break;
            }
            System.out.println("You want to continue adding other nos?");
            String s = scan.next();
            if (s.equalsIgnoreCase("y"))
                flag = true;
            else
                flag = false;
        }
        printHashingMap();
    }

    public static void printHashingMap()
    {
        Iterator<Map.Entry<Integer, AddList>> itr = hashingMap.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<Integer, AddList> entry = itr.next();
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }
}
