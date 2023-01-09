import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_BJ_7569_토마토 {
    static int box[][][];
    static int m, n, h;
    static boolean visited[][][];
    static Deque<int []> q = new ArrayDeque<>();
    // 상 하 좌 우 위 아래
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int cnt = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        box = new int[m][n][h];
        visited = new boolean[m][n][h];

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    box[k][j][i] = Integer.parseInt(st.nextToken());
                    if(box[k][j][i] == 1){
                        visited[k][j][i] = true;
                        q.add(new int[] {k, j, i});
                    }
                }
            }
        }

        bfs();
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(box[k][j][i] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println(cnt-1);
    }
    public static void bfs(){
        while(!q.isEmpty()){
            int temp = q.size();
            for(int c=0; c<temp; c++) {
                int[] arr = q.poll();
                for (int i = 0; i < 6; i++) {
                    int nx = arr[0] + dx[i];
                    int ny = arr[1] + dy[i];
                    int nh = arr[2] + dh[i];

                    if (check(nx, ny, nh) && box[nx][ny][nh] == 0 && !visited[nx][ny][nh]) {
                        q.offer(new int[]{nx, ny, nh});
                        box[nx][ny][nh] = 1;
                        visited[nx][ny][nh] = true;
                    }
                }
            }
            cnt++;
        }//while
    }//bfs
    public static boolean check(int x, int y, int z){
        if(x<0 || x>=m || y<0 || y>=n || z<0 || z>=h )
            return false;
        return true;
    }
}
