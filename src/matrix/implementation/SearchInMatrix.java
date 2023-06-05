package matrix.implementation;
/*
Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given.
The task is to find whether element X is present in the matrix or not.

Examples:
Input : mat[][] = { {1, 5, 9},
                   {14, 20, 21},
                   {30, 34, 43} }
       x = 14
Output : YES

Input : mat[][] = { {1, 5, 9, 11},
                   {14, 20, 21, 26},
                   {30, 34, 43, 50} }
       x = 42
Output : NO
* */

public class SearchInMatrix {

    public static boolean searchInMatrix(int[][] matrix, int x){
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j] == x){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int x = 42;
        int[][] matrix = { { 1, 5, 9, 11 },
                { 14, 20, 21, 26 },
                { 30, 34, 43, 50 }};


        if (searchInMatrix(matrix, x)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

}
