import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<node>[] graph;
    static int vNum;
    static class node{
        int v;
        int w;

        public node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vNum = Integer.parseInt(st.nextToken()); // 정점 개수
        int eNum = Integer.parseInt(st.nextToken()); // 간선 개수
        int k = Integer.parseInt(br.readLine()); // 시작 정점 번호
        graph = new ArrayList[vNum+1];
        for(int i=1; i<=vNum; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<eNum; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // start
            int v = Integer.parseInt(st.nextToken()); // end
            int w = Integer.parseInt(st.nextToken()); // weight

            graph[u].add(new node(v, w));
        }
        dijkstra(k);
    }//main
    private static void dijkstra(int k){
        PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.w - o2.w;
            }
        }); // 가중치 합 기준으로 정렬
        int[] dist = new int[vNum+1];

        // 최소 거리 정보 답을 배열 => 최대값으로 초기화
        for(int i=1; i<=vNum; i++)
            dist[i] = Integer.MAX_VALUE;
        pq.offer(new node(k, 0));
        // 시작 지점은 거리 0
        dist[k] = 0;

        while(!pq.isEmpty()){
            node cur = pq.poll();
            if(dist[cur.v] < cur.w)
                continue;

            for(int i=0; i<graph[cur.v].size(); i++){
                node next = graph[cur.v].get(i);

                if(dist[next.v] > cur.w+next.w){
                    dist[next.v] = cur.w+next.w;
                    pq.offer(new node(next.v, dist[next.v]));
                }
            }
        }//while

        for(int i=1; i<=vNum; i++){
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }//dijkstra
}
