import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tree = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                tree[i][j] = Integer.parseInt(st.nextToken());
                if(i==n-1){
                   dp[i][j] = tree[i][j];
                }
            }
        }//for

        for(int i=n-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[i][j] = Math.max(dp[i+1][j] + tree[i][j], dp[i+1][j+1]+tree[i][j]);
            }
        }
        System.out.println(dp[0][0]);
    }//main
}
