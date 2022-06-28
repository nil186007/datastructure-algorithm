package com.code.nil.preparation;

public class TappingRainWater {
    public static void main(String[] args) {
        int[] array = {4,2,0,3,2,5};
        System.out.println(trapWater(array));
    }

    public static int trapWater(int[] a) {
        if (a.length <= 1) {
            return 0;
        }
        int count = 0;
        int left = 0;
        int right = a.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while(left<right){

            if(a[left]>leftMax) leftMax=a[left];
            if(a[right]>rightMax) rightMax=a[right];
            // a taller bar exists on left pointer's right side
            if(leftMax<rightMax){
                count += Math.max(0,leftMax-a[left]);
                ++left;
            }else{
                count += Math.max(0,rightMax-a[right]);
                --right;
            }
        }
        return count;
    }
}
