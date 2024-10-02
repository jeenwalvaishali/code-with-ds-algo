package javabasicquestions;

public class ReverseAString {

    public static void stringBuffer(String str){
        StringBuffer stringBuffer = new StringBuffer(str);
        System.out.print(stringBuffer.reverse());
    }

    public static void iterativeMethod(String str){
        char[] charArray = str.toCharArray();
        for(int i = charArray.length -1; i>=0; i--){
            System.out.print(charArray[i]);
        }
    }

    public static void main(String[] args) {

        iterativeMethod("Hello");
        System.out.println();
        stringBuffer("doog");
    }
}
