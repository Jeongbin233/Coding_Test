import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ans = -1;

        boolean[] building = new boolean[f+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {s, 0});
        building[s] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == g){
                ans = cur[1];
                break;
            }

            if(check(cur[0]+u) && !building[cur[0]+u]){
                q.add(new int[] {cur[0]+u, cur[1]+1});
                building[cur[0]+u] = true;
            }

            if(check(cur[0]-d) && !building[cur[0]-d]){
                q.add(new int[] {cur[0]-d, cur[1]+1});
                building[cur[0]-d] = true;
            }
        }

        if(ans == -1)
            System.out.println("use the stairs");
        else
            System.out.println(ans);
    }//main
    private static boolean check(int x){
        if(x<=0 || x>f)
            return false;
        return true;
    }
}
