import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_BJ_2407_조합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger sum = BigInteger.ONE;
        BigInteger div = BigInteger.ONE;

        for(int i=0; i<m; i++){
            sum = sum.multiply(new BigInteger(String.valueOf(n-i)));
            div = div.multiply(new BigInteger(String.valueOf(i+1)));
        }

        BigInteger ans = sum.divide(div);
        System.out.println(ans);
    }//main
}
