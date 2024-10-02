package javabasicquestions;

public class RemoveWhiteSpaceString {
    public static void inbuiltMethod(String str){
        String strNoSpace = str.replaceAll("\\s+", "");
        System.out.println(strNoSpace);
    }

    public static void noSpaceString(String str){
        StringBuilder newString = new StringBuilder();
        char[] charArray = str.toCharArray();

        for(int i = 0; i<charArray.length; i++){
            if((charArray[i] != ' ') && charArray[i] != '\t'){
                newString.append(charArray[i]);
            }
        }

        System.out.println(newString);
    }

    public static void main(String[] args) {
        String str = "OneSpace TwoSpaces  ThreeSpaces   FourSpaces    Tab        End";
        noSpaceString(str);
        inbuiltMethod(str);
    }
}
