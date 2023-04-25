import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class location{
        int x;
        int time;
        public location(int x, int time){
            this.x=x;
            this.time=time;
        }
    }
    static int n, k, ans, method;
    static int[] visited = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ans = 0;

        if(n==k) {
            System.out.println(ans);
            System.out.println(1);
        }
        else{
            method = bfs(n);
            System.out.println(ans+1);
            System.out.println(method);
        }
    }//main
    private static int bfs(int x){
        Queue<location> q = new LinkedList<>();
        visited[x]=0;
        q.offer(new location(x, 0));
        ans = Integer.MAX_VALUE;
        int way = 0;

        while(!q.isEmpty()){
            location now = q.poll();

            if(now.x-1 == k || now.x+1==k || now.x*2==k){
                if(ans == now.time)
                    way++;
                else if(ans > now.time){
                    ans = now.time;
                    way=1;
                }
            }

            if(now.x-1 >= 0 && (visited[now.x] == now.time+1 || visited[now.x]==0)){
                visited[now.x] = now.time+1;
                q.offer(new location(now.x-1, now.time+1));
            }
            if(now.x+1 <= 100000 && (visited[now.x] == now.time+1 || visited[now.x]==0)){
                visited[now.x] = now.time+1;
                q.offer(new location(now.x+1, now.time+1));
            }
            if(now.x*2 <= 100000 && (visited[now.x] == now.time+1 || visited[now.x]==0)){
                visited[now.x] = now.time+1;
                q.offer(new location(now.x*2, now.time+1));
            }

        }//while
        return way;
    }//bfs
}
