package matrix.implementation;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public static void printMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i<m; i++){
            for (int j=0; j<n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rowZeroes = new HashSet<>();
        Set<Integer> colZeroes = new HashSet<>();


        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0 ){
                   rowZeroes.add(i);
                   colZeroes.add(j);
                }
            }
        }

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++) {
                if (rowZeroes.contains(i) || colZeroes.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args){

        int[][] matrix = {{ 1, 1, 1 }, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
        printMatrix(matrix);



    }
}
