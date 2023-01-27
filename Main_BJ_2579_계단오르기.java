import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_2579_계단오르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n+1];
        for(int i=1; i<=n; i++)
            stairs[i] = Integer.parseInt(br.readLine());

        /*
            연속된 세 개의 계단을 밟을 수는 없음
            따라서 "밟는" 계단(n)을 기준으로 두 개의 값 중 최댓값을 구해야함.

            n번째 계단에서의 최대값은 1, 2 중에서 최대값이다.
            1. n-3번째 계단의 최대값 + n-1 계단값 + n 계단값
            2. n-2번째 계단의 최대값 + n 계단값

            문제 예시)
            마지막 계단(6)에서의 최대값
            1. 3번째 계단에서의 최대값 + 5번째 + 6번째 계단 밟을 때
            2. 4번째 계단에서의 최대값 + 6번째 계단 밟을 때
            1, 2 중 최대값을 고르면 된다

         */
        int[] dp = new int[n+1];
        //dp[0] = 0;
        dp[1] = stairs[1]; // 첫 번째 계단은 첫 번째 밟았을 때가 최대

        if(n>1)
            dp[2] = stairs[1] + stairs[2]; // 두 번째 계단은 1+2 계단 밟았을 때가 최대

        for(int i=3; i<=n; i++)
            dp[i] = Math.max(dp[i-3] + stairs[i-1] +stairs[i], dp[i-2] + stairs[i]);

        System.out.println(dp[n]);

    }//main
}
