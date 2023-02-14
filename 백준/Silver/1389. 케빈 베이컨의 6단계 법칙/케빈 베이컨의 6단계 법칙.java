import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] adj;
    static int INF = 10000;
    public static void main(String[] args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j)
                    adj[i][j] = 0;
                else
                    adj[i][j] = INF;
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a][b] = 1;
            adj[b][a] = 1;
        }


        for(int k=1; k<=n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                }
            }
        }

        int min = 0;
        int sum = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++){
            int temp = 0;
            for(int j=1; j<=n; j++){
                if(j != i) {
                    temp += adj[i][j];
                }
            }
            if(sum > temp){
                sum = temp;
                min = i;
            }
        }

        System.out.println(min);
    }//main
}
