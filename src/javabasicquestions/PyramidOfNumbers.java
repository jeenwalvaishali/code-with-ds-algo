package javabasicquestions;

public class PyramidOfNumbers {

    public static void pyramid1(int numOfRows){
        int rowCount = 1;
        for(int i = numOfRows; i>0; i--){
            for(int j = 1; j<=i; j++){
                System.out.print("");
            }

            for(int j = 1; j<=rowCount; j++){
                System.out.print(rowCount+ "");
            }

            System.out.println();

            rowCount++;

        }
    }

    public static void main(String[] args) {
        int numOfRows = 9;
        pyramid1(9);
    }

}
