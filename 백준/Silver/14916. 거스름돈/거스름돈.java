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
            // 1 3
            if(i/5 == 0 && i%2 == 1)
                dp[i] = -1;
            // 2 4
            else if(i/5 == 0 && i%2 == 0)
                dp[i] = i/2;
            // 5의 배수
            else if(i%5 == 0)
                dp[i] = i/5;
            else{
                //5의 배수가 아니고, 5원 동전 최대 + 나머지 2원으로 거스름돈 가능할 경우
                if(dp[i%5] > 0)
                    dp[i] = i/5 + dp[i%5];
                // 6~9 케이스를 처리하기 위함
                else if(i%2 == 0 && i/5 == 1)
                    dp[i] = i/2;
                // 5원 동전 1개 뺐을 때 + 나머지 2원으로 거스름돈 가능할 경우
                else
                    dp[i] = (i/5-1)+dp[i%5+5];
            }
        }
        System.out.println(dp[n]);
    }//main
}
