import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, Integer> map = new HashMap<>();
    static int[] ans, arr;
    static boolean[] visited;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        ans = new int[m];
        visited = new boolean[n];
        Arrays.sort(arr);
        perm(0);
//        System.out.println(map.keySet());
    }//main
    private static void perm(int cnt){
        if(cnt == m){
            String str = "";
            for(int i=0; i<m; i++)
                str += ans[i] + " ";

            if(!map.containsKey(str)) {
                map.put(str, 1);
                for (int i = 0; i < m; i++) {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            ans[cnt] = arr[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }//perm
}
