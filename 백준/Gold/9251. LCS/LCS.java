import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static Integer[][] dp;
    static char[] arr1, arr2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        arr1 = str1.toCharArray();
        arr2 = str2.toCharArray();
        dp = new Integer[arr1.length][arr2.length];

        System.out.println(LCS(arr1.length-1, arr2.length-1));

    }//main
    //TOP DOWN
    private static int LCS(int x, int y){
        if(x < 0 || y < 0)
            return 0;

        //탐색 x
        if(dp[x][y] == null){
            dp[x][y] = 0;

            if(arr1[x] == arr2[y])
                dp[x][y] = LCS(x-1, y-1) + 1;

            else
                dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
        }
        return dp[x][y];
    }//LCS

    //BOTTOM UP
    /*
    // 공집합 표현을 위해 인덱스가 한 줄씩 추가 됨
		int[][] dp = new int[length_1 + 1][length_2 + 1];

		// 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음)
		for(int i = 1; i <= length_1; i++) {
			for(int j = 1; j <= length_2; j++) {

				// (i-1)과 (j-1) 번째 문자가 서로 같다면
				if(str1[i - 1] == str2[j - 1]) {
					// 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}

				// 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// Top-Down 때와는 다르게 dp 인덱스가 한 줄씩 추가되었으므로 -1을 하지 않음
		System.out.println(dp[length_1][length_2]);
     */
}
