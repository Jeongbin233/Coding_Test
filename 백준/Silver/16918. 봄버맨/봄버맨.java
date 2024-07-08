import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, n;
    static char[][] map;
    static int[][] bomb;
    //상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int time = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        bomb = new int[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'O')
                    bomb[i][j] = 3; // 폭탄 터질 시간
            }
        }

        while(time++ < n){
            if(time%2 == 0)
                install();
            else explode();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void install(){
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == '.'){
                    map[i][j] = 'O';
                    bomb[i][j] = time+3;
                }
            }
        }
    }

    public static void explode(){
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(bomb[i][j] == time){
                    map[i][j] = '.';
                    for(int k=0; k<4; k++){
                        int nx = i  + dx[k];
                        int ny = j + dy[k];
                        if(check(nx, ny) && map[nx][ny]=='O' && bomb[nx][ny] != time) {
                            bomb[nx][ny] = 0;
                            map[nx][ny] = '.';
                        }
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y){
        if(x<0 || y<0 || x>=r || y>=c)
            return false;
        return true;
    }
}
