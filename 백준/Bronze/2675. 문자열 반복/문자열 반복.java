import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            String str = st.nextToken();


            StringBuilder sb = new StringBuilder();
            for(int j=0; j<str.length(); j++) {
                int idx = 0;
                while (idx < len) {
                    sb.append(str.charAt(j));
                    idx++;
                }
            }

            System.out.println(sb);
        }
    }//main
}
