import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /*
        1   2   3   4   5   6   7   8   9   10
        -1  1  -1   2   1   3   2   4   3   2

        11  12  13  14  15  16  17  18  19  20
        4   3   5   4   3   5   4   6   5   4
         */
        int[] dp = new int[n+1];
        dp[1] = -1;
        for(int i=1; i<=n; i++){
            if(i/5 == 0 && i%2 == 1)
                dp[i] = -1;
            else if(i/5 == 0 && i%2 == 0)
                dp[i] = i/2;
            else if(i%5 == 0)
                dp[i] = i/5;
            else{
                if(dp[i%5] > 0)
                    dp[i] = i/5 + dp[i%5];
                else if(i%2 == 0 && i/5 == 1)
                    dp[i] = i/2;
                else
                    dp[i] = (i/5-1)+dp[i%5+5];
            }
        }
        System.out.println(dp[n]);
    }//main
}
