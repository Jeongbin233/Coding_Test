import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_11399_ATM {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = arr[0];
        int[] sum = new int[n];
        sum[0] = arr[0];
        for(int i=1; i<n; i++){
            sum[i] = sum[i-1]+arr[i];
            cnt+=sum[i];
        }
        System.out.println(cnt);
    }
}
