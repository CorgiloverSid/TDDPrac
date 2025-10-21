package org.example;

public class LeapYear {

    public static Boolean isLeapYear(int year) {
//        if (year % 400 == 0) return true;
//        if (year % 100 == 0) return false;
//        return year % 4 == 0;
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

}
