package matrix.implementation;
/*
How to Print the Elements of a Matrix or Grid:
Printing elements of a matrix or two-dimensional array can be done using two “for” loops.
* */

public class PrintMatrix {

    public static void main(String[] args){

        int[][] matrix = {{ 1, 2, 3, 4 }, {5, 6, 7, 8}, {9, 10, 11, 12}};

        for (int i = 0; i<3; i++){
            for (int j=0; j<4; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
