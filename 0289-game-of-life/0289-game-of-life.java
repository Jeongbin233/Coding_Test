class Solution {
    public void gameOfLife(int[][] board) {
        // 상 하 좌 우 우상 우하 좌상 좌하
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

        int n = board.length;
        int m = board[0].length;
        int[][] copy = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[i][j] = board[i][j];
            }
        }

        int[][] result = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copy[i][j] == 0){
                    int cnt = 0;
                    for(int c=0; c<8; c++){
                        int nx = i+dx[c];
                        int ny = j+dy[c];
                        if(check(n, m, nx, ny) && copy[nx][ny] == 1)
                            cnt++;
                    }
                    if(cnt == 3)
                        board[i][j] = 1;
                    else
                        board[i][j] = 0;
                }
                else{
                    int cnt = 0;
                    for(int c=0; c<8; c++){
                        int nx = i+dx[c];
                        int ny = j+dy[c];
                        if(check(n, m, nx, ny) && copy[nx][ny] == 1)
                            cnt++;
                    }
                    if(cnt < 2)
                        board[i][j] = 0;
                    else if(cnt == 2 || cnt == 3)
                        board[i][j] = 1;
                    else if(cnt>3)
                        board[i][j] = 0;
                }
            }//for
        }//for
    }//gameOfLife
    public boolean check(int n, int m, int x, int y){
        if(x<0 || y<0 || x>=n || y>=m)
            return false;
        return true;
    }
}