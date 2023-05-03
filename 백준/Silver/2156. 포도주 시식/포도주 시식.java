import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] grape = new int[n+1];
        for(int i=1; i<=n; i++)
            grape[i] =  sc.nextInt();
        int[] dp = new int[n+1];

        dp[1] = grape[1];
        if(n>=2)
            dp[2] = grape[1]+grape[2];
        for(int i=3; i<=n; i++)
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+grape[i]), dp[i-3]+grape[i-1]+grape[i]);

        System.out.println(dp[n]);
    }//main
}
