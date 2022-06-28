package com.code.nil.preparation;

public class MatrixTraversal {

    public static void main(String[] args) {

        int[][] arr = { {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 5, 6, 3}};

        int[][] result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    result[i][j] = arr[i][j] + Math.min(result[i - 1][j], result[i][j - 1]);
                } else if (i - 1 >= 0 && j - 1 < 0) {
                    result[i][j] = arr[i][j] + result[i - 1][j];
                } else if (i - 1 < 0 && j - 1 >= 0) {
                    result[i][j] = arr[i][j] + result[i][j - 1];
                } else {
                    result[i][j] = arr[i][j];
                }
            }
        }

        System.out.println(result);

    }
}
