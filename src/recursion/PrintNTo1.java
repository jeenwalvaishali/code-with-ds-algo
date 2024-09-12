package recursion;

public class PrintNTo1 {

    public static void solve(int n){
        if(n==0) return;
        System.out.print(n + " ");
        solve(n-1);
    }

    public static void main(String[] args) {
        int n = 7;
        solve(n);
    }
}
