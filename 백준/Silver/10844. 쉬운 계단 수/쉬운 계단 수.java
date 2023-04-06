import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // dp[i][j]: i번째 자리수가 j일 때 계단수 값
        long[][] dp = new long[n+1][10];
        long mod = 1000000000;

        // 첫 번째 자리수는 1개
        for(int i=1; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                if(j==9){
                    dp[i][9] = dp[i-1][8]%mod;
                }
                else if(j==0){
                    dp[i][0] = dp[i-1][1]%mod;
                }
                else
                    dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%mod;
            }//j
        }//i

        long ans = 0;
        for(int i=0; i<10; i++){
            ans += dp[n][i];
        }
        System.out.println(ans%mod);




    }//main
}
