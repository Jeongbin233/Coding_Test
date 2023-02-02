import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BJ_9375_패션왕신해빈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            int ans = 1;

            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if(clothes.containsKey(type))
                    clothes.put(type, clothes.get(type)+1);
                else
                    clothes.put(type, 1);
            }

//          (종류 + 1) * (종류 + 1) ... -1
            for(int value : clothes.values())
                ans *= value+1;

            System.out.println(ans-1);
        }//test case
    }//main
}
