import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int max, n, m;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                dfs(i, j, 0, 0, visited);
                visited[i][j] = false;
                shape(i, j);
            }
        }

        System.out.println(max);

    }//main
    private static void dfs(int x, int y, int cnt, int sum, boolean[][] visited){
        if(cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check(nx, ny) && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1, sum+map[x][y], visited);
                visited[nx][ny] = false;
            }
        }
    }//dfs

    private static boolean check(int x, int y){
        if(x<0 || y<0 || x>=n || y>=m)
            return false;
        return true;
    }//check

    private static void shape(int x, int y){
        if(x<n-2 && y<m-1)
            max = Math.max(max, map[x][y]+map[x+1][y]+map[x+2][y]+map[x+1][y+1]);

        if(x<n-2 && y>0)
            max = Math.max(max, map[x][y]+map[x+1][y]+map[x+2][y]+map[x+1][y-1]);

        if(x>0 && y<m-2)
            max = Math.max(max, map[x][y]+map[x][y+1]+map[x][y+2]+map[x-1][y+1]);

        if(x<n-1 && y<m-2)
            max = Math.max(max, map[x][y]+map[x][y+1]+map[x][y+2]+map[x+1][y+1]);

    }//shape
}
