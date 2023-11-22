package matrix.questions;

import java.util.HashSet;
import java.util.Set;

/*Explanation:

Sets Initialization:

rowSet and colSet are sets used to keep track of characters encountered in rows and columns, respectively.
checkBlock uses blockSet to keep track of characters in a 3x3 block.
Row and Column Validation (Inside isValidSudoku):

For each row and column, a new set (rowSet or colSet) is initialized to check for duplicate characters.
The code iterates through each cell in the row and column.
If the current character is not a dot (.), it checks if it's already in the set. If yes, it returns false (invalid). Otherwise, it adds the character to the set.
Block Validation (Inside isValidSudoku):

The code uses nested loops to iterate through each 3x3 block.
For each block, it calls the checkBlock function to check the validity of the block.
Block Validation (checkBlock Function):

checkBlock checks the validity of a 3x3 block starting from indices (idxI, idxJ).
A new set (blockSet) is initialized for each block.
It loops through each cell in the block, skipping empty cells (dots).
It checks for duplicate characters in the block. If found, it returns false (invalid).
If all tests pass, the block is considered valid.
Conclusion (isValidSudoku):

If all tests for rows, columns, and blocks pass, the function returns true, indicating that
 the Sudoku board is valid.*/

/*idxI and idxJ represent the starting indices of the 3x3 block.
Adding 3 to each of these indices gives the ending indices of the block (exclusive).
So, rows will represent the end index of the rows in the block, and cols will represent the end index of the columns
 in the block.
For example, if idxI is 0 and idxJ is 0, then rows and cols will be 3. This means we'll be considering the 3x3 block
 starting from the top-left corner of the Sudoku board.
 The loop in checkBlock then iterates through this block, checking each cell for validity*/



public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        //Initialize sets for checking rows and cols
         Set<Character> rowSet = null;
         Set<Character> colSet = null;


         //Iterate through each row and col
         for (int i = 0; i<9; i++){
             //ReInitialize sets for each row and col
             rowSet = new HashSet<>();
             colSet = new HashSet<>();

             for (int j = 0; j<9; j++){
                 char r = board[i][j]; //Current char in the row
                 char c = board[j][i]; //Current char in the column

                 //check for duplicate characters in the row
                 if(r != '.'){
                     if(rowSet.contains(r)){
                         return false;
                     }else {
                         rowSet.add(r);
                     }
                 }

                 //check for duplicate charcters in the column
                 if( c != '.'){
                     if(colSet.contains(c)){
                         return false;
                     }else {
                         colSet.add(c);
                     }
                 }
             }
         }

        //check each 3*3 block
        for (int i = 0; i<9; i = i+3){
            for (int j =0; j<9; j = j+3){
                //check the validity of each block
                if(!checkBlock(i , j, board)){
                    return false;
                }
            }
        }

        //If all the test pass, the board is valid
        return true;
    }

    private static boolean checkBlock(int idxI, int idxJ, char[][] board) {

        Set<Character> blockSet = new HashSet<>();
        int rows = idxI+3; // end row index of block
        int cols = idxJ+3; // end col index of block

        for (int i = idxI; i<rows; i++){
            for(int j = idxJ; j<cols; j++){
                if(board[i][j] == '.'){
                    continue;
                }

                if(blockSet.contains(board[i][j])){
                    return false;
                }

                blockSet.add(board[i][j]);
            }
        }

        return true;
    }
}
