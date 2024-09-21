class Solution {
      class Edge implements Comparable<Edge> {
        int src, dest, weight;
        
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
    
    class UnionFind {
        int[] parent;
        
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Edge> edges = new ArrayList<>();
        
        // 모든 가능한 간선 생성
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + 
                             Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, weight));
            }
        }
        
        // 간선을 가중치 기준으로 정렬
        Collections.sort(edges);
        
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        int edgesUsed = 0;
        
        // 크루스칼 알고리즘 수행
        for (Edge edge : edges) {
            if (uf.find(edge.src) != uf.find(edge.dest)) {
                uf.union(edge.src, edge.dest);
                cost += edge.weight;
                edgesUsed++;
                
                // n-1개의 간선을 선택하면 모든 점이 연결됨
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }
        
        return cost;
    }
}