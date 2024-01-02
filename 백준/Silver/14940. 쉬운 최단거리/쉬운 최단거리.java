import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] dis, map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dis = new int[n][m];
        map = new int[n][m];
        int x = 0, y = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dis[i][j] == 0 && map[i][j] == 1)
                    System.out.print(-1 + " ");
                else if(map[i][j] == 2)
                    System.out.print(0 + " ");
                else
                   System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }


    }//main
    public static void bfs(int x, int y){
        Deque<int[]> q = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[n][m];

        q.add(new int[] {x, y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];

            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(check(nx, ny) && map[nx][ny] != 0 && !visited[nx][ny]){
                    q.add(new int[] {nx, ny});
                    dis[nx][ny] = dis[cx][cy] + 1;
                    visited[nx][ny] = true;
                }
            }//for(4방)
        }//while
    }//bfs
    public static boolean check(int x, int y){
        if(x<0 || y<0 || x>=n || y>=m)
            return false;
        return true;
    }//check
}
