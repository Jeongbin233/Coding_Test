import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_11725_트리의부모찾기 {
    static ArrayList<Integer>[] list;
    static int n;
    static int[] parents;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        parents = new int[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++)
            list[i] = new ArrayList<Integer>();

        for(int i=1; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        dfs(1);
        for(int i=2; i<=n; i++)
            System.out.println(parents[i]);
    }//main
    private static void dfs(int p){
        visited[p] = true;
        for(int i=0; i<list[p].size(); i++){
            if(!visited[list[p].get(i)]){
                parents[list[p].get(i)] = p;
                dfs(list[p].get(i));
            }
        }
    }//dfs
}
