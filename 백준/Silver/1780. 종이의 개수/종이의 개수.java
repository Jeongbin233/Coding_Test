import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int plus, zero, minus;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        devide(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);

    }//main
    private static void devide(int x, int y, int size){
        int num = paper[x][y];
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(num != paper[i][j]){
                    devide(x, y, size/3);
                    devide(x, y+size/3, size/3);
                    devide(x, y+size/3*2, size/3);

                    devide(x+size/3, y, size/3);
                    devide(x+size/3, y+size/3, size/3);
                    devide(x+size/3, y+size/3*2, size/3);

                    devide(x + size/3*2, y, size/3);
                    devide(x + size/3*2, y+size/3, size/3);
                    devide(x + size/3*2, y+size/3*2, size/3);

                    return;
                }
            }
        }

        if(num == -1)
            minus++;
        else if(num == 0)
            zero++;
        else
            plus++;
    }//devide
}
