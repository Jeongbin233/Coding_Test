import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static int[][] map;
    static boolean[][] visited, topMap;
    // 상 하 좌 우 왼위 오위 왼아 오아
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        topMap = new boolean[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]!=0 && !topMap[i][j])
                    bfs(i, j);
            }
        }
        System.out.println(ans);

    }//main
    private static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        ArrayList<int []> top = new ArrayList<>();

        visited = new boolean[n][m];
        visited[x][y] = true;
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<8; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(check(nx, ny) && !visited[nx][ny]){
                    if(map[nx][ny] > map[cur[0]][cur[1]]) //현재보다 더 높은 지점 있으면 return
                        return;
                    else if(map[nx][ny] == map[cur[0]][cur[1]]){
                        q.offer(new int[] {nx, ny});
                        top.add(new int[] {nx, ny});
                    }
                    visited[nx][ny] = true;
                }//if
            }
        }//while
        for(int i=0; i<top.size(); i++){
            int[] cur = top.get(i);
            topMap[cur[0]][cur[1]] = true;
        }
        ans++;
    }//bfs

    private static boolean check(int x, int y){
        if(x<0 || y<0 || x>=n || y>=m)
            return false;
        return true;
    }
}
