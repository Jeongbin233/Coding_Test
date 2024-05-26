import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, num1, num2;
    static int[][] family = new int[101][101];
    static int[] visited = new int[101];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        st = new StringTokenizer(str);

        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            family[x][y] = 1;
            family[y][x] = 1;
        }//for

        bfs();
        if(visited[num2] > 0)
            System.out.println(visited[num2] -1);
        else
            System.out.println(-1);


    }//main


    public static void bfs(){
        Deque<Integer> q = new ArrayDeque<>();
        q.push(num1);
        visited[num1] = 1;
        while(!q.isEmpty()){
            int person = q.poll();
            int tmp = visited[person];
            for(int i=1; i<=n; i++){
                if(family[person][i]>0 && visited[i]<=0){
                    q.push(i);
                    visited[i] = tmp + 1;
                }
            }
        }

    }//bfs
}
