package com.code.nil.preparation;

public class MedianSortedArray {
    public static void main(String[] args) {

        int[] a1 = {1, 3};
        int[] a2 = {2, 4};

        int[] result = new int[a1.length + a2.length];

        int a1Index = 0;
        int a2Index = 0;

        int i = 0;
        while (a1Index < a1.length && a2Index < a2.length) {
            if (a1[a1Index] < a2[a2Index]) {
                result[i] = a1[a1Index];
                a1Index++;
            } else {
                result[i] = a2[a2Index];
                a2Index++;
            }
            i++;
        }

        if (a1.length == a1Index) {
            for (int k = a2Index; k < a2.length; k++) {
                result[i] = a2[k];
                i++;
            }
        }
        if (a2Index == a2.length) {
            for (int k = a1Index; k < a1.length; k++) {
                result[i] = a1[k];
                i++;
            }
        }

        double median = 0;

        int val = (a1.length + a2.length +1 )/2;
        if( ( a1.length + a2.length )%2 ==0){
            median = (result[val-1]+result[val])/2.0;
        }else{
            median=result[val-1]/1.0;
        }

        System.out.println(median);

        System.out.println(getMedian(a1,a2));

    }

    public static double getMedian(int[] a, int[] b) {

        int left = 0;
        int right = a.length;

        while (left < right) {
            int cut1 = (left + right) / 2;
            int cut2 = (a.length + b.length + 1) / 2 - cut1;

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];

            int right1 = cut1 == a.length ? Integer.MAX_VALUE : a[cut1];
            int right2 = cut2 == b.length ? Integer.MAX_VALUE : b[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((a.length + b.length) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2)/1.0;
                }
            } else if (left1 > right2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }
        return 0;
    }
}
