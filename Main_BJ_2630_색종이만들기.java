import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2630_색종이만들기 {
    static int[][] paper;
    static int n, blue, white;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        devide(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }//main
    private static void devide(int x, int y, int size){
        int check = paper[x][y];
        boolean flag = true;
        for(int i=x; i<x+size; i++){
            if(!flag)
                break;
            for(int j=y; j<y+size; j++){
                if(check != paper[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if(!flag){
            devide(x, y, size/2);
            devide(x, y+size/2, size/2);
            devide(x+size/2 , y, size/2);
            devide(x+size/2, y+size/2, size/2);
        }
        else{
            if(check == 1)
                blue++;
            else
                white++;
        }

    }//devide
}
