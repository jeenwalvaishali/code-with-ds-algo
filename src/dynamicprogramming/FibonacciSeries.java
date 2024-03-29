package dynamicprogramming;

import java.util.Arrays;

/*The expression F(n) = F(n-1) + F(n-2) is a fundamental recursive formula used to generate the Fibonacci sequence. Let's break down this formula step by step:

F(n): This represents the nth term of the Fibonacci sequence. It's the number you want to calculate.

F(n-1): This represents the (n-1)th term of the Fibonacci sequence, which is the term that immediately precedes the nth term.

F(n-2): This represents the (n-2)th term of the Fibonacci sequence, which is the term that precedes the (n-1)th term.

The formula states that to find the nth term (F(n)) in the Fibonacci sequence, you add the two previous terms, which are the (n-1)th term (F(n-1)) and the (n-2)th term (F(n-2)). This is the essence of the Fibonacci sequence, where each term is generated by summing up the two terms that come before it.

Here's how it works with a practical example:

Let's calculate F(5) using F(n) = F(n-1) + F(n-2):

F(5) = F(4) + F(3)

Now, to find F(4) and F(3), we use the same formula recursively:

F(4) = F(3) + F(2)
F(3) = F(2) + F(1)

Continuing to calculate the values for F(2) and F(1):

F(2) = F(1) + F(0)

Now, we've reached the base cases:

F(1) = 1
F(0) = 0

We can now substitute these values back into the previous equations:

F(2) = 1 + 0 = 1
F(3) = 1 + 1 = 2
F(4) = 2 + 1 = 3
F(5) = 3 + 2 = 5

So, F(5) is equal to 5, which is the 5th term in the Fibonacci sequence.

This recursive formula is at the heart of the Fibonacci sequence and is used to generate the sequence iteratively, where each term is a sum of the two previous terms.




*/
public class FibonacciSeries {

    public static int recursiveMethod(int n){
        if(n <= 1){
            return n;
        }

        int x = recursiveMethod(n - 1);
        int y = recursiveMethod(n - 2);

        return x + y;
    }

    public static int topDownMemoization(int n, int[] dp){
        if(n <= 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = topDownMemoization(n-1, dp) + topDownMemoization(n-2, dp);
        return dp[n];
    }

    public static void main(String[] args){
        int n =10;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        int result = topDownMemoization(n, dp);
    }

}
