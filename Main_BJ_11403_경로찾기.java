import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11403_경로찾기 {
    static int[][] adj;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new int[n][n];
        int[][] ans = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(route(i, j))
                    ans[i][j] = 1;
                else
                    ans[i][j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(ans[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }//main
    private static boolean route(int start, int end){
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
//        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<n; i++){
                if(adj[cur][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        if(visited[end])
            return true;
        return false;
    }//route
}
