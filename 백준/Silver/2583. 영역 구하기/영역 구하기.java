import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, sum;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> areas = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int ly = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            for(int x=lx; x<rx; x++){
                for(int y=ly; y<ry; y++){
                    visited[x][y] = true;
                    map[x][y]++;
                }
            }
        }//k

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j]) {
                    int area = bfs(i, j);
                    sum++;
                    areas.add(area);
                }
            }
        }
        System.out.println(sum);
        Collections.sort(areas);
        for(int i=0; i<areas.size(); i++)
            System.out.print(areas.get(i)+" ");

    }//main
    private static int bfs(int x, int y){
        int area = 0;
        visited[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            area++;
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(check(nx, ny) && !visited[nx][ny]){
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }//while
        return area;
    }//bfs
    private static boolean check(int x, int y) {
        if(x<0 || y<0 || x>=n || y>=m)
            return false;
        return true;
    }
}
