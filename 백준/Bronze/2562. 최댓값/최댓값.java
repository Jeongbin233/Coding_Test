import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max, index;
        max = Integer.parseInt(br.readLine());
        index = 1;
        for(int i=2; i<10; i++){
            int num = Integer.parseInt(br.readLine());
            if(max < num){
                max = num;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
