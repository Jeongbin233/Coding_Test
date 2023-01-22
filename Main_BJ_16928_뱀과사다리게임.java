import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_16928_뱀과사다리게임 {
    static int[] map = new int[101];
    static int[] snakeLadder = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            snakeLadder[a] = b;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            snakeLadder[a] = b;
        }

        bfs();
        System.out.println(map[100]);
    }//main

    private static void bfs() {
       Queue<Integer> q = new ArrayDeque<>();
       //처음 시작은 무조건 1
       q.add(1);
       visited[1] = true;

       while(!q.isEmpty()){
           int cur = q.poll();
           //주사위: 한 번에 6칸 이동
           for(int i=1; i<=6; i++){
               int nx = cur+i;
               //다음 좌표가 100보다 작거나 같아야 하고, 방문하지 않았어야함
               if(nx <= 100 && !visited[nx]){
                   //다음 좌표가 사다리를 타고 이동할 수 있을 때 && 이동한 좌표가 방문한 적 없을 때
                   if(snakeLadder[nx] != 0 && !visited[snakeLadder[nx]]){
                       // 큐에 저장, 이동 거리 작성, 방문처리
                       q.offer(snakeLadder[nx]);
                       map[snakeLadder[nx]] = map[cur] + 1;
                       map[nx] = map[cur] + 1;
                       visited[nx] = true;
                       visited[snakeLadder[nx]] = true;
                   }
                   //다음 좌표가 사다리가 없을 때
                   else if(snakeLadder[nx] == 0){
                       //다음 좌표 큐에 저장, 이동 거리 작성, 방문처리
                       map[nx] = map[cur] + 1;
                       q.offer(nx);
                       visited[nx] = true;
                   }
               }
           }
       }//while
    }//bfs
}
