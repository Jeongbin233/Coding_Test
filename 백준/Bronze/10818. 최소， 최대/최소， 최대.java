import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());
        int min = max;

        for(int i=0; i<n-1; i++){
            int num = Integer.parseInt(st.nextToken());
            if(max < num)
                max = num;
            else if(min > num)
                min = num;
        }
        System.out.println(min + " " + max);

    }
}
