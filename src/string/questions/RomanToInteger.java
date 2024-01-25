package string.questions;

import java.util.HashMap;
import java.util.Map;
/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

public class RomanToInteger {

    public int romanToInt(String s){
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;

        int i =0;
        while(i < s.length()){
            if((i+1) < s.length() && romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i+1))){
                result = result + (romanValues.get(s.charAt(i+1)) - romanValues.get(s.charAt(i)));
                i = i+2;
            }else{
                result = result + romanValues.get(s.charAt(i));
                i++;
            }
        }

        return result;
    }
}

/*
Here's a step-by-step explanation of how the code works:

The method begins by creating a HashMap named romanValues to store the values corresponding to Roman numerals.
The keys are characters representing Roman numerals ('I', 'V', 'X', 'L', 'C', 'D', 'M'), and the values are their respective
numerical values (1, 5, 10, 50, 100, 500, 1000).

The method initializes an integer variable result to 0. This variable will store the final integer value obtained from the Roman numeral.

The code uses a while loop to iterate through each character of the input string s.

Inside the loop, it checks whether the current character is smaller than the next character and whether there is a next character available.
If both conditions are true, it means that the current Roman numeral is part of a subtractive pair (e.g., IV for 4 or IX for 9).
In such cases, it subtracts the value of the current numeral from the value of the next numeral and adds the result to the result.
The loop increments i by 2 to skip the next character.

If the above condition is not met, it means that the current Roman numeral is not part of a subtractive pair.
In this case, it simply adds the value of the current numeral to the result, and the loop increments i by 1 to move to the next character.

The loop continues until all characters in the input string have been processed.

The method returns the final integer result.
*/
