import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_1003_피보나치함수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n+1][2];

            dp[0][0] = 1;
            dp[0][1] = 0;

            if(n>=1) {
                dp[1][0] = 0;
                dp[1][1] = 1;
            }

            for(int i=2; i<=n; i++){
                dp[i][0] = dp[i-1][0] + dp[i-2][0];
                dp[i][1] = dp[i-1][1] + dp[i-2][1];
            }

            System.out.println(dp[n][0] + " " + dp[n][1]);
        }//for
    }//main
}
