import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int ans;
    static int w, h;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while(w!=0 && h!=0) {
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visited = new boolean[h][w];
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && map[i][j]==1) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
            ans = 0;

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }//while
    }//main
    private static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<8; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(check(nx, ny) && !visited[nx][ny] && map[nx][ny]==1){
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }//bfs
    private static boolean check(int x, int y){
        if(x<0 || x>=h || y<0 || y>=w)
            return false;
        return true;
    }
}
