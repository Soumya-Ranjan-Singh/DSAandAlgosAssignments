//Write a program Calendar.java that takes the month and year as command-line
//arguments and prints the Calendar of the month. Store the Calendar in an 2D Array,
//the first dimension the week of the month and the second dimension stores the day
//of the week. Print the result as following.

package com.datastructure.programs;

import java.util.Scanner;

public class Calender {
    public static void calendarPage(String[][] days, int month, int year) {
        int[] monthlyDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] weekDays = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        int firstDay = startDayOfMonth(month, year);

        if (year%4 == 0){
            if (year%100 != 0 || year%400== 0){
                monthlyDays[2] = 29;
            }
        }

        int j = 0;
        for (int i = 0; i < 7; i++) {
            days[j][i] = weekDays[i];
        }
        //System.arraycopy(weekDays, 0, days[j], 0, 7);

        int numOfDay = 1;
        for (int i = 1; i < 7; i++){
            for (j = 0; j < 7; j++){
                if (firstDay >= numOfDay) {
                    days[i][j] = " ";
                    firstDay--;
                }
                else if (numOfDay <= monthlyDays[month]) {
                    days[i][j] = String.valueOf(numOfDay);
                    numOfDay++;
                } else {
                    days[i][j] = " ";
                }
            }
        }
    }
    public static int startDayOfMonth(int month, int year) {
        int m, y, d, num;
        int day=1;

        y = year - (14 - month) / month;
        num = y + y / 4 - y / 100 + y / 400;
        m = month + 12 * ((14 - month) / 12) - 2;
        d = (day + num + (31 * m) / 12) % 7;
        return d;
    }
    public static void printCalender(String[][] days, int month, int year) {
        String[] months = { "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" };
        System.out.println("\n       " + months[month - 1].toUpperCase() + " " + year);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(days[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("\n---------WELCOME TO JAVA CALENDAR---------\n");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month :- ");
        int month = input.nextInt();
        System.out.print("Enter year :- ");
        int yr = input.nextInt();
        String[][] days = new String[7][7];

        calendarPage(days, month, yr);
        printCalender(days, month, yr);
    }
}
