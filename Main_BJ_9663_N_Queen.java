import sun.nio.cs.ext.MacHebrew;

import java.util.Scanner;

public class Main_BJ_9663_N_Queen {
    static int n, ans;
    static int[] col;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        col = new int[n];

        /*
        col[i] = j => i열 j행에 말이 위치한다.
        ex) col[1] = 1, col[2] = 1 => 같은 1행에 존재하게됨
        ex) col[1] = 2, col[3] = 0 => |1-3| == |2-0| => 같은 대각선에 존재함
         */

        nQueen(0);
        System.out.println(ans);

    }//main
    private static void nQueen(int depth){
        if(depth == n){
            ans++;
            return;
        }

        for(int i=0; i<n; i++){
            //말 두기
            col[depth] = i;
            //놓을 수 있는지 확인
            if(promising(depth)){
                //된다면 다시 재귀
                nQueen(depth + 1);
            }
        }
    }//nQueen

    private static boolean promising(int depth){
        for(int i=0; i<depth; i++){
            //같은 행에 존재할 때
            if(col[depth] == col[i])
                return false;

            //대각선에 존재할 때
            else if(Math.abs(depth - i) == Math.abs(col[depth] - col[i]))
                return false;
        }
        return true;

    }//promising
}
