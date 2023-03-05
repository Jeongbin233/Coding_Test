import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] item;
    static ArrayList<Node>[] adj;
    static int n, m, r, max;
    static int[][] dijkstra;
    static class Node{
        int to;
        int w;

        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 지역 개수
        m = Integer.parseInt(st.nextToken()); // 수색 범위
        r = Integer.parseInt(st.nextToken()); // 길의 개수

        item = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            item[i] = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++)
            adj[i] = new ArrayList<Node>();

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, w));
            adj[b].add(new Node(a, w));
        }

        dijkstra = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            Dijkstra(i);

        System.out.println(max);
    }//main
    private static void Dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w - o2.w;
            }
        });
        int[] dist = new int[n+1];

        for(int i=1; i<=n; i++)
            dist[i] = Integer.MAX_VALUE;
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.to] < cur.w)
                continue;

            for(int i=0; i<adj[cur.to].size(); i++){
                Node next = adj[cur.to].get(i);

                if(dist[next.to] > cur.w + next.w){
                    dist[next.to] = cur.w + next.w;
                    pq.offer(new Node(next.to, dist[next.to]));
                }
            }
        }//while

        int sum = 0;
        for(int i=1; i<=n; i++){
            if(m >= dist[i])
                sum += item[i];
        }
        max = Math.max(sum, max);
    }//dijkstra
}
