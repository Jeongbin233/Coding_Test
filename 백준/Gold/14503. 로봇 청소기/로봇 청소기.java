import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static int[][] map;
    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulation(r, c, d);
        System.out.println(ans);
    }//main
    private static void simulation(int r, int c, int d){
        int x = r;
        int y = c;
        int dir = d;

        while(true){
            boolean flag = false;
            if(map[x][y] == 0) {
                //현재 칸 청소
                map[x][y] = 2;
                ans++;
            }

            //주변 살펴보기
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 청소되지 않은 칸이 있는 경우
                if(check(nx, ny) && map[nx][ny] == 0){
                    // 반시계 방향으로 회전
                    dir--;
                    if(dir < 0)
                        dir = 3;
                    flag = true;
                    break;
                }
            }//for

            //주변 청소되지 않은 칸이 있을 때
            if(flag){
                // 앞쪽 칸이 청소되지 않았을 때
                int[] next = front(x, y, dir);
                if(check(next[0], next[1]) && map[next[0]][next[1]] == 0) {
                    //전진
                    x = next[0];
                    y = next[1];
                }
            }

            // 주변 4칸 중 청소되지 않은 빈 칸이 없을 때
            else {
                int[] next = back(x, y, dir);
                //한 칸 후진할 수 있으면
                if(check(next[0], next[1])){
                    x = next[0];
                    y = next[1];
                }

                //없으면 탈출
                else
                    break;
            }
        }//while
    }//simulation
    private static boolean check(int x, int y){
        if(x<0 || y<0 || x>=n || y>=m || map[x][y] == 1)
            return false;
        return true;
    }//check

    private static int[] front(int x, int y, int dir){
        switch (dir) {
            case 0: {//북
                int nx = x - 1;
                return new int[]{nx, y, dir};
            }

            case 1: { //동
                int ny = y + 1;
                return new int[]{x, ny, dir};
            }

            case 2: {//남
                int nx = x + 1;
                return new int[]{nx, y, dir};
            }

            case 3: { //서
                int ny = y - 1;
                return new int[] {x, ny, dir};
            }
        }//switch
        //아무것도 아닐 때
        return new int[] {-1, -1, -1};
    }//front
    private static int[] back(int x, int y, int dir){
        switch (dir) {
            case 0: {//북
                int nx = x + 1;
                return new int[]{nx, y, dir};
            }

            case 1: { //동
                int ny = y - 1;
                return new int[]{x, ny, dir};
            }
            case 2: {//남
                int nx = x - 1;
                return new int[]{nx, y, dir};
            }

            case 3: { //서
                int ny = y + 1;
                return new int[] {x, ny, dir};
            }
        }//switch
        //아무것도 아닐 때
        return new int[] {-1, -1, -1};
    }//back
}
