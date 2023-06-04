import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] map;
    static boolean[][] visited;
    static int l, endx, endy;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int curx = Integer.parseInt(st.nextToken());
            int cury = Integer.parseInt(st.nextToken());
            map[curx][cury] = 1;

            st = new StringTokenizer(br.readLine());
            endx = Integer.parseInt(st.nextToken());
            endy = Integer.parseInt(st.nextToken());

            int cnt = bfs(curx, cury);
            System.out.println(cnt);
        }//test case
    }//main
    private static int bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[] {x, y, 0});

        while (!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == endx && cur[1] == endy)
                return cur[2];
            
            for(int i=0; i<8; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(check(nx, ny) && !visited[nx][ny]){
                    q.add(new int[] {nx, ny, cur[2]+1});
                    visited[nx][ny] = true;
                }
            }
        }//while

        return -1;
    }//bfs
    private static boolean check(int x, int y){
        if(x<0 || y<0 || x>=l || y>=l)
            return false;
        return true;
    }
}
