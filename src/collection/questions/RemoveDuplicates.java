package collection.questions;

/*1. Remove Duplicates from a List
Problem
Given a list of integers, remove duplicates while keeping only unique values.

Input:
[10, 20, 10, 30, 20, 40]

Output:
[10, 20, 30, 40]*/

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {

    public static void removeDuplicates(int[] nums){
        Set<Integer> set = new TreeSet<>();

        for (int num : nums){
                set.add(num);
        }

        System.out.println(set);
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 10, 30, 20, 40};

        removeDuplicates(nums);
    }
}
