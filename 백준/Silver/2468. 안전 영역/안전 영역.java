import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int low=Integer.MAX_VALUE;
    static int high=Integer.MIN_VALUE;
    static int n;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                low = Math.min(low, map[i][j]);
                high = Math.max(high, map[i][j]);
            }
        }


        int sum=1;
        for(int k = low; k<high; k++){
            visited = new boolean[n][n];
            int temp = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(!visited[i][j] && map[i][j]>k){
                        bfs(i, j, k);
                        temp++;
                    }
                    else if(!visited[i][j] && map[i][j]<=k)
                        visited[i][j] = true;
                }
            }
            if(sum <= temp) {
                sum = temp;
            }
        }
        
        System.out.println(sum);

    }//main
    private static void bfs(int x, int y, int level){
        Queue<int []> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[] {x, y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(check(nx, ny) && map[nx][ny]>level && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }

        }//while
    }//bfs
    private static boolean check(int x, int y){
        if(x<0 || y<0 || x>=n || y>=n)
            return false;
        return true;
    }//check
}

