class Solution {
    public int numIslands(char[][] grid) {
        //상하좌우 
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    visited[i][j] = true;
                    q.add(new int[] {i, j});
                    cnt++;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int c=0; c<4; c++){
                            int nx = cur[0] + dx[c];
                            int ny = cur[1] + dy[c];

                            if(check(nx, ny, n, m) && !visited[nx][ny] && grid[nx][ny]=='1'){
                                q.offer(new int[] {nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }//for

        return cnt;
    }

    public boolean check(int x, int y, int n, int m){
        if(x<0 || y<0 || x>=n || y>=m)
            return false;
        return true;
    }
}