import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> moving = new ArrayDeque<>();
    static Queue<Cloud> clouds = new ArrayDeque<>();

    // 0번째 자리는 의미 없는 수
    static int[] dx = {-2, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-2, -1, -1, 0, 1, 1 ,1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            moving.add(new int[] {d, s});
        }

        clouds.add(new Cloud (n-1, 0));
        clouds.add(new Cloud (n-1, 1));
        clouds.add(new Cloud (n-2, 0));
        clouds.add(new Cloud (n-2, 1));

        int size = moving.size();
        for(int i=0; i<size; i++) {
            move_clouds(); // 구름 이동 및 구름위치 물 양 1 증가
            copy_water_magic(); // 물복사마법
            make_clouds();
        }
        sum_water();
    }//main

    public static void sum_water(){
        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void move_clouds(){
        int[] cloud_moving = moving.poll();
        int dir = cloud_moving[0];
        int dis = cloud_moving[1];

        for(Cloud cloud: clouds){
            cloud.x = (n + cloud.x + dx[dir]*(dis % n)) % n ;
            cloud.y = (n + cloud.y + dy[dir]*(dis % n)) % n;
            // 물 뿌리기
            map[cloud.x][cloud.y] += 1;
        }
    }//move clouds

    public static void copy_water_magic(){
        int size = clouds.size();
        for(int i=0; i<size; i++){
            Cloud cloud = clouds.poll();
            int x = cloud.x;
            int y = cloud.y;

            visited[x][y] = true;
            for(int j=2; j<=8; j+=2) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (check(nx, ny)) {
                    if (map[nx][ny] > 0)
                        map[x][y]++;
                }
            }
        }
    }//물복사 마법

    public static void make_clouds(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //queue.contains는 객체 참조때문에 안 됨
//                if(map[i][j] >= 2 && !old_clouds.contains(new Cloud(i, j))) {
                if (map[i][j] >= 2 && !visited[i][j]){
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }

        visited = new boolean[n][n];
    }

    public static boolean check(int x, int y){
        if(x<0 || y<0 || x>=n || y>=n)
            return false;
        return true;
    }

    static class Cloud {
        int x;
        int y;

        Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
