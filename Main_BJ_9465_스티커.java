import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_9465_스티커 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
           int n = Integer.parseInt(br.readLine());
           int[][] sticker = new int[2][n];
           int[][] dp = new int[2][n+1];
           for(int i=0; i<2; i++){
               st = new StringTokenizer(br.readLine());
               for(int j=0; j<n; j++){
                   sticker[i][j] = Integer.parseInt(st.nextToken());
               }
           }

           int max;
           dp[0][1] = sticker[0][0];
           dp[1][1] = sticker[1][0];
           for(int i=2; i<=n; i++){
               dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i-1];
               dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i-1];
           }
           max = Math.max(dp[0][n], dp[1][n]);
           System.out.println(max);
        }//test case
    }//main

}
