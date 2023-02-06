import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n+1];
            dp[1] = 1;
            if(n>3) {
                dp[2] = 1;
                dp[3] = 1;

                for (int i = 4; i <= n; i++)
                    dp[i] = dp[i - 2] + dp[i - 3];
            }
            else if(n>2){
                dp[2] = 1;
                dp[3] = 1;
            }
            else if(n>1)
                dp[2] = 1;

            System.out.println(dp[n]);
        }//tc
    }//main
}
