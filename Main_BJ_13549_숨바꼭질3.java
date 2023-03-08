import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_BJ_13549_숨바꼭질3 {
    static int MAX = 100000;
    static boolean[] visited = new boolean[MAX+1];
    static class location{
        int x;
        int cnt;

        public location(int x, int cnt){
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<location> pq = new PriorityQueue<>(new Comparator<location>() {
            @Override
            public int compare(location o1, location o2) {
                return o1.cnt - o2.cnt;
            }
        });
        visited[n] = true;
        pq.offer(new location(n, 0));
        int min = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            location cur = pq.poll();
            visited[cur.x] = true;

            if(cur.x == m){
                min = Math.min(min, cur.cnt);
            }

            if(cur.x-1 >= 0 && !visited[cur.x-1])
                pq.offer(new location(cur.x-1, cur.cnt+1));

            if(cur.x+1 <= MAX && !visited[cur.x+1])
                pq.offer(new location(cur.x + 1, cur.cnt + 1));

            if(cur.x * 2 <= MAX && !visited[cur.x * 2])
                pq.offer(new location(2 * cur.x, cur.cnt));

        }//while

        System.out.println(min);
    }//main
}
/*
5 17
10 6 4
20 11 9 6 4
20 12 11 9 7 5 4
20 12 11 9 8 5 5 3
19 18 13 21 24
 */