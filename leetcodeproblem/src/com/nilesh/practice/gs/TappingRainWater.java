package com.nilesh.practice.gs;

public class TappingRainWater {

    public static void main(String[] args) {

        int [] a = {3,1,3,0,4,2,1};

        int left=0;
        int right = a.length-1;
        int leftmaX = a[left];
        int rightMax = a[right];
        int sum = 0;
        int [] rightSide = new int [a.length];
        for(int i=0 ; i<a.length; i++){

        }

        while(left<right){
            if(a[left]>leftmaX) leftmaX = a[left];
            if(a[right]>rightMax) rightMax = a[right];

            if(leftmaX < rightMax){
                sum += Math.max(0,leftmaX-a[left]);
                left++;
            }else{
                sum += Math.max(0,rightMax-a[right]);
                right--;
            }
        }

        System.out.println(sum);
    }
}
