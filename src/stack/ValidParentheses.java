package stack;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char ch : charArray){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else {
                if (stack.empty()){
                    return false;
                }
                char stackTop = stack.peek();
                if(ch == ')' && stackTop == '(' ||
                        ch == '}' && stackTop == '{'||
                        ch == ']' && stackTop == '['){
                    stack.pop();
                }else {
                    return false;
                }
            }

        }

        return stack.empty();
    }

    public static void main(String[] args) {
       String s = "(]";

       boolean result = isValid(s);
       System.out.println(result);
    }
}
