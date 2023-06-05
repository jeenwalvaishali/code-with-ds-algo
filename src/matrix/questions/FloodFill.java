package matrix.questions;
/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
Replace the color of all the aforementioned pixels with color.
Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.
*/

public class FloodFill {

    public static void main(String[] args){

        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;

        int[][] output = floodFill(image, sr, sc, color);
        int row = output.length;
        int col = output[0].length;

        for (int i = 0; i<row; i++){
            for (int j=0; j<col; j++){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
        int oldColor = image[sr][sc];

        if(oldColor == color){
            return image;
        }

        dfs(image, sc, sc, oldColor, color);

        return image;

    }

    private static void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        if(row<0 || row>=rows || col<0 || col>=cols || image[row][col] != oldColor){
            return;
        }

        image[row][col] = newColor;

        dfs(image, row-1, col, oldColor, newColor);
        dfs(image, row+1, col, oldColor, newColor);
        dfs(image, row, col-1, oldColor, newColor);
        dfs(image, row, col+1, oldColor, newColor);


    }
}

