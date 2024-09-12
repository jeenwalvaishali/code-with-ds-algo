package recursion;

public class Print1ToN {
    public static void solve(int n){
        if(n==0) return;
        solve(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 7;
        solve(n);
    }
}
