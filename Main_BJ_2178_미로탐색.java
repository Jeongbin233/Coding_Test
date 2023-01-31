import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2178_미로탐색 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] sum;
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        sum = new int[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        bfs();
        System.out.println(sum[n-1][m-1]);

    }//main
    private static void bfs(){
        Queue<Point> q = new ArrayDeque<>();
        Point start = new Point(0, 0);
        q.offer(start);
        visited[start.x][start.y] = true;
        sum[start.x][start.y] = 1;

        while (!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x == n-1 && cur.y == m-1)
                break;

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(check(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    sum[nx][ny] = sum[cur.x][cur.y] + 1;
                }
            }
        }


    }//bfs
    private static boolean check(int x, int y){
        if(x<0 || x>=n || y<0 || y>=m)
            return false;
        return true;
    }
}
