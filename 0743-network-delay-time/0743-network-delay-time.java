class Solution {
    public List<int[]>[] graph;
    public int[] dist;
    
    public int networkDelayTime(int[][] times, int n, int k) {
        createGraph(n, times);
        dijkstra(n, k);
        int result = 0;

        for (int i = 1 ; i <= n ; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, dist[i]);
        }

        return result;
    }
    
    private void dijkstra(int n, int k){
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        dist[k] = 0;
        q.offer(new int[] {k, 0});
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            
            for(int[] next : graph[current[0]]){
                if(dist[next[0]] > current[1] + next[1]){
                    dist[next[0]] = current[1] + next[1];
                    q.offer(new int[] {next[0], dist[next[0]]});
                }
            }
        }
    }
    
    private void createGraph(int n, int[][] times){
        graph = new List[n+1];
        
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] time: times){
            graph[time[0]].add(new int[] {time[1], time[2]});
        }
    }
}