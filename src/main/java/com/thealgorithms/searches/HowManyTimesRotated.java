package com.thealgorithms.searches;

import java.util.*;

/*
    Problem Statement: 
    Given an array, find out how many times it has to been rotated 
    from its initial sorted position.
    Input-Output:
    Eg. [11,12,15,18,2,5,6,8]
    It has been rotated: 4 times
    (One rotation means putting the first element to the end)
    Note: The array cannot contain duplicates

    Logic: 
    The position of the minimum element will give the number of times the array has been rotated
    from its initial sorted position.
    Eg. For [2,5,6,8,11,12,15,18], 1 rotation gives [5,6,8,11,12,15,18,2], 2 rotations [6,8,11,12,15,18,2,5] and so on.
    Finding the minimum element will take O(N) time but, we can  use Binary Search to find the mimimum element, we can reduce the complexity to O(log N).
    If we look at the rotated array, to identify the minimum element (say a[i]), we observe that  a[i-1]>a[i]<a[i+1].
    To avoid overflow we can add a[(i+a.length-1)%a.length]>a[i]<a[(i+1)%a.length].

    Some other test cases: 
    1. [1,2,3,4] Number of rotations: 0 or 4(Both valid)
    2. [15,17,2,3,5] Number of rotations: 3
 */
class HowManyTimesRotated {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(
            "The array has been rotated " + rotated(a) + " times"
        );
        sc.close();
    }

    public static int rotated(int[] a) {

        int low = 0;
        int high = a.length - 1;
        int res = -1;
        int l = a.length;

        while (low <= high) {
            int mid = low + (high - low)/2;

            int next = (mid + 1) % l;
            int prev = (mid + l - 1) % l;

            if ((a[mid] <= a[next]) && (a[mid] <= a[prev])){
                res = mid;
                break;
            }
            else if (a[mid] >= a[0]){
                low = mid + 1;
            }
            else if (a[mid] <= a[l-1]){
                high = mid - 1;
            }
        }
        return res;

    }
}
