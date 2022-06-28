package com.code.nil.preparation.striver.binarysearch;

public class RoatedArrayPivot {

    //{5,6,7,8,9,2,3,4}
    public static int findPivot(int[] a) {
        int left = 0;
        int right = a.length;

        while (left <= right) {
            int mid = (left + right)/2;
            if (mid >= 1 && mid < a.length - 2) {
                if (a[mid - 1] > a[mid] && a[mid] <= a[mid + 1]) {
                    return a[mid];
                }
            } else if (mid >= 1  && mid == a.length - 1) {
                if (a[mid - 1] > a[mid]) {
                    return a[mid];
                }
            }
            if (a[mid] > a[left]) {
                left = mid ;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] a = {5,6,7,8,9,2,2,3,3,4};
        System.out.println(findPivot(a));
    }
}
