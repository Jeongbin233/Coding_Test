import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, num1, num2;
    static int res = -1;
    static boolean flag = false;
    static List<Integer>[] family;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        family = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            family[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        String str = br.readLine();
        st = new StringTokenizer(str);

        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            family[x].add(y);
            family[y].add(x);
        }//for

        dfs(num1, num2, 0);
        System.out.println(res);
    }
    public static void dfs(int a, int b, int cnt){
        if(a == b){
            res = cnt;
            return;
        }

        visited[a] = true;
        for(int i=0; i<family[a].size(); i++){
            int next = family[a].get(i);
            if(!visited[next]){
                dfs(next, b, cnt+1);
            }
        }
    }//dfs
}
