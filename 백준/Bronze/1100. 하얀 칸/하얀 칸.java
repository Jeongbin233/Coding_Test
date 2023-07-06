import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chess = new char[8][8];
        for(int i=0; i<8; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                chess[i][j] = str.charAt(j);
            }
        }
        int cnt = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i%2 == 0){
                    if(j%2 == 0 && chess[i][j] == 'F')
                        cnt++;
                }
                else{
                    if(j%2 == 1 && chess[i][j] == 'F')
                        cnt++;
                }
            }
        }
        System.out.println(cnt);
    }//main
}
