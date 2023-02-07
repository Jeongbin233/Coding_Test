import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        /*
            1 1       => 1
            2 1+1     => 1
            3 1+1+1   => 1
            4 2       => 1
            5 2+1     => 2
            6 2+1+1   => 2
            7 2+1+1+1 => 2
            8 2+2     => 1
            9 3       => 1
            10 3+1    => 2
            11 3+1+1  => 2
            12 3+1+1+1 => 2
            13 3+2    =>2
            14 3+2+1  => 3
            15 3+2+1+1 => 3
            16 4       => 1
            17 4+1     => 2
           ...
           dp[i] = min(dp[i-j*j])+1
           어떤수 i 최적해 =>
            i보다 작은 모든 제곱수들 중 i-제곱수를 한 해 중 가장 작은 해 + 1

           ex:
           2 : 2보다 작거나 같은 제곱수 == 1 => dp[2] = dp[1] + 1
           4 : 4보다 작거나 같은 제곱수 == 1, 2 => dp[4] = min(dp[3], dp[0]) +1
         */

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
               min = Math.min(min, dp[i-j*j]);
            }
            dp[i]=min+1;
        }
    System.out.println(dp[n]);
    }//main
}
