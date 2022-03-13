package com.home.company;

import com.home.company.SalesMan;

import java.util.Comparator;

public class AgeComparator implements Comparator<SalesMan> {
    @Override
    public int compare(SalesMan s1, SalesMan s2) {
        if (s2.Age < s1.Age) {
            return 1;
        }
        return -1;
    }
}
