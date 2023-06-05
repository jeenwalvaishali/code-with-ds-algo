package matrix.implementation;

import java.util.Arrays;

public class SortMatrix {

    public static void printMatrix(int[][] matrix, int n){
        for (int i = 0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sortMatrix(int[][] matrix, int n){
        int[] temp = new int[n*n];
        int k = 0;

        for (int i = 0; i<n; i++){
            for (int j=0; j<n; j++){
                temp[k++] = matrix[i][j];
            }
        }

        Arrays.sort(temp);

        k=0;
        for (int i = 0; i<n; i++){
            for (int j=0; j<n; j++){
                matrix[i][j] = temp[k++];
            }
        }

    }


    public static void main(String[] args){
        int[][] mat
                = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
        int n = 3;

        System.out.println("Original Matrix:");
        printMatrix(mat, n);

        sortMatrix(mat, n);

        System.out.println("\nMatrix After Sorting:");
        printMatrix(mat, n);
    }
}
