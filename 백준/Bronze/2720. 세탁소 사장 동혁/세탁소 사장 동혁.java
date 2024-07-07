import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        double[] coins = {25, 10, 5, 1};
        for(int i=0; i<t; i++){
            int c = Integer.parseInt(br.readLine());
            int[] cnt = new int[4];

            cnt[0] = (int) (c / coins[0]);
            c %= coins[0];

            cnt[1] = (int) (c/coins[1]);
            c %= coins[1];

            cnt[2] = (int) (c/coins[2]);
            c %= coins[2];

            cnt[3] = (int) (c/coins[3]);
            c %= coins[3];

            System.out.println(cnt[0] +" "+ cnt[1] +" " + cnt[2]+ " " + cnt[3]);
        }
    }
}
