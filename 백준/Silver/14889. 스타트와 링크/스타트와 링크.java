import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n, ans = Integer.MAX_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(ans);

    }//main
    private static void comb(int idx, int cnt){
        if(cnt == n/2){
            cal();
            return;
        }

        for(int i=idx; i<n; i++){
            if(visited[i])
                continue;

            visited[i] = true;
            comb(i+1, cnt+1);
            visited[i] = false;
        }

    }//comb
    private static void cal(){
        int start=0;
        int link=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i] && visited[j])
                    start += map[i][j]+map[j][i];
                else if(!visited[i] && !visited[j])
                    link += map[i][j]+map[j][i];
            }
        }
        start /= 2;
        link /= 2;
        ans = Math.min(ans, Math.abs(start-link));
    }
}
