import java.util.Scanner;

public class Main_BJ_11727_2xn타일링2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];

        /*
        1 => 1
        2 => 3
        3 => 5
        4 => 11
         */

        dp[0] = 1;
        if(n>1)
            dp[1] = 3;

        for(int i=2; i<n; i++){
            dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;
        }

        System.out.println(dp[n-1]);
    }//main
}
