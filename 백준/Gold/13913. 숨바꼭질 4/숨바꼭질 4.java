import java.util.*;

public class Main {
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];
    static int n, k, ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        ans = 0;
        StringBuilder sb = new StringBuilder();
        int idx = k;

        if(n == k){
            System.out.println(ans);
            System.out.println(n);
        }
        else {
            bfs(n);
            System.out.println(ans);
            Stack<Integer> stack = new Stack<>();
            while(idx != n){
                stack.push(idx);
                idx = parent[idx];
            }
            stack.push(idx);

            while(!stack.isEmpty())
                sb.append(stack.pop()).append(" ");
            System.out.println(sb);
        }

    }//main
    private static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.offer(n);

        while (!q.isEmpty()){
            int size = q.size();
            ans++;

            for(int i=0; i<size; i++) {
                int cur = q.poll();

                if(cur-1 == k || cur+1==k || cur*2 == k){
                    parent[k] = cur;
                    return;
                }

                if(cur-1 >= 0 && !visited[cur-1]){
                    visited[cur-1] = true;
                    parent[cur-1] = cur;
                    q.offer(cur-1);
                }
                if(cur+1 <= 100000 && !visited[cur+1]){
                    visited[cur+1] = true;
                    parent[cur+1] = cur;
                    q.offer(cur+1);
                }
                if(cur*2 <= 100000 && !visited[cur*2]){
                    visited[cur*2] = true;
                    parent[cur*2] = cur;
                    q.offer(cur*2);
                }
            }
        }
    }//bfs
}
