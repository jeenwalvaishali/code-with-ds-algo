package matrix.implementation;
/*
Program to print the Diagonals of a Matrix
Given a 2D square matrix, print the Principal and Secondary diagonals.

Examples :
Input:
1 2 3 4
4 3 2 1
7 8 9 6
6 5 4 3
Output:
Principal Diagonal: 1, 3, 9, 3
Secondary Diagonal: 4, 2, 8, 6

Input:
1 1 1
1 1 1
1 1 1
Output:
Principal Diagonal: 1, 1, 1
Secondary Diagonal: 1, 1, 1
* */

public class PrintDiagonals {

    public static void main(String[] args){
        int n = 4;
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 }
        };

        printPrincipalDiagonal(matrix, n);
        System.out.println();
        printSecondaryDiagonal(matrix, n);
    }

    private static void printSecondaryDiagonal(int[][] matrix, int n) {
        for (int i = 0; i<n; i++){
            for (int j=0; j<n; j++){
                if(i == j){
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.print("");
        }
    }

    private static void printPrincipalDiagonal(int[][] matrix, int n) {
        for (int i = 0; i<n; i++){
            for (int j=0; j<n; j++){
                if(i+j == n-1){
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.print("");
        }
    }

}
