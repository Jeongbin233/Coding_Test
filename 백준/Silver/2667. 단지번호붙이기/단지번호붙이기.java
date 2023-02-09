import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt, house, n;
    static PriorityQueue<Integer> houses = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]) {
                    house = 1;
                    cnt++;
                    dfs(i, j);
                    houses.add(house);
                }
            }
        }

        System.out.println(cnt);
        int size = houses.size();
        for(int i=0; i<size; i++)
            System.out.println(houses.poll());
    }//main
    private static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(check(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0){
                house++;
                dfs(nx, ny);
            }
        }

    }//dfs

    private static boolean check(int x, int y){
        if(x<0 || y<0 || x>=n || y>=n)
            return false;
        return true;
    }//check
}
