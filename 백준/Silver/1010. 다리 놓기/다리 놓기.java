import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=0; tc<t; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            BigInteger[] arr = new BigInteger[31];
            arr[1] = BigInteger.ONE;
            for(int i=2; i<=30; i++){
                arr[i] = arr[i-1].multiply(BigInteger.valueOf(i));
            }
            if(n==m)
                System.out.println(1);
            else
                System.out.println(arr[m].divide(arr[n].multiply(arr[m-n])));
        }
    }
}
