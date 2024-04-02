package recursion;

public class FibonacciSeries {

    public static int fibonacciSeries(int n){
        if(n <= 1){
            return n;
        }else{
            return fibonacciSeries(n-1) + fibonacciSeries(n-2);
        }
    }

    public static void main(String[] args) {
        int n = 10; // Example: to calculate the 10th Fibonacci number
        System.out.println("Fibonacci series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSeries(i) + " ");
        }
    }
}
