import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, dis;
    //상 하 좌 우 우상 우하 좌상 좌하
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dis = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                map[i][j] = dis[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(n, m);
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dis[i][j] > max)
                    max = dis[i][j];
            }
        }
        System.out.println(max);
    }
    public static void bfs(int n, int m){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1){
                    q.add(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] qp = q.poll();
            int x = qp[0];
            int y = qp[1];
            visited[x][y] = true;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (check(nx, ny, n, m) && map[nx][ny] != 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    if (map[x][y] == 1)
                        dis[nx][ny] = 1;
                    else if (dis[nx][ny] > 0 && dis[x][y] + 1 < dis[nx][ny])
                        dis[nx][ny] = dis[x][y] + 1;
                    else if(dis[nx][ny] == 0)
                        dis[nx][ny] = dis[x][y] + 1;
                    }
            }
        }




    }//bfs

    public static boolean check(int x, int y, int n, int m){
        if(x<0 || y<0 || x>=n || y>=m)
            return false;
        return true;
    }
}
