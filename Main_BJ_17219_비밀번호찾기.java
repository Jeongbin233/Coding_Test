import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_17219_비밀번호찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();
            map.put(site, pw);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            sb.append(map.get(key)+"\n");
        }
        System.out.print(sb);

    }//main
}
