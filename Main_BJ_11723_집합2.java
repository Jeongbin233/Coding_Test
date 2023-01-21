import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_11723_집합2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        int bit = 0;
        StringTokenizer st;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num;
            switch (command){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    //num-1 => 20이 들어왔을 떼 2*19가 20번째라서
                    bit |= (1 << (num-1));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bit  &= ~(1 << (num-1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bit & (1<<(num-1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bit ^= (1 << (num-1));
                    break;
                case "all":
                    bit |= (~0);
                    break;
                case "empty":
                    bit &= 0;
                    break;
            }//switch
        }
        System.out.println(sb);
    }//main
}
