import java.util.Scanner;

public class Main_BJ_2775_부녀회장이될테야 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc=0; tc<t; tc++){
           int k = sc.nextInt();
           int n = sc.nextInt();
           int[][] dp = new int[k+1][n+1];
           for(int i=1; i<=n; i++){
               dp[0][i] = i;
           }
           for(int i=1; i<=k; i++) {
               for(int j=1; j<=n; j++) {
                   for(int z=1; z<=j; z++)
                       dp[i][j] += dp[i - 1][z];
               }
           }
           System.out.println(dp[k][n]);
        }//tc
    }//main
}
/*
2: 1 4 10
1: 1 3 6
0: 1 2 3
 */