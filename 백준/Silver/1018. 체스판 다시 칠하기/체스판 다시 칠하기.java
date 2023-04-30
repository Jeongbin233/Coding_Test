import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m, ans;
    static char[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        ans = Integer.MAX_VALUE;
        for(int i=0; i<n-7; i++){
            for(int j=0; j<m-7; j++){
                find(i, j);
            }
        }
        System.out.println(ans);
    }//main
    private static void find(int x, int y){
        int cnt = 0;
        char cur = map[x][y];
        for(int i=x; i<x+8; i++){
            for(int j=y; j<y+8; j++){
                if(cur != map[i][j])
                    cnt++;

                if(cur == 'B')
                    cur='W';
                else cur='B';
            }
            if(cur == 'B')
                cur='W';
            else cur='B';
        }
        cnt = Math.min(cnt, 64-cnt);
        ans = Math.min(cnt, ans);

    }//find
}
