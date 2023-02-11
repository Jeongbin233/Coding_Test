import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Register{
        int num;
        String cmd;

        public Register(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }

        int D(){
            return (num*2)%10000;
        }

        int S(){
            if(num == 0)
                return 9999;
            return num-1;
        }

        int L(){
            return num%1000 * 10 + num/1000;
        }

        int R(){
            return num%10 *1000 + num/10;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Register> q = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];

            q.offer(new Register(a, ""));
            visited[a] = true;

            while(!q.isEmpty()){
                Register cur = q.poll();
                if(cur.num == b){
                    System.out.println(cur.cmd);
                    break;
                }

                if(!visited[cur.D()]){
                    q.offer(new Register(cur.D(), cur.cmd+"D"));
                    visited[cur.D()] = true;
                }

                if(!visited[cur.S()]){
                    q.offer(new Register(cur.S(), cur.cmd+"S"));
                    visited[cur.S()] = true;
                }

                if(!visited[cur.L()]){
                    q.offer(new Register(cur.L(), cur.cmd+"L"));
                    visited[cur.L()] = true;
                }

                if(!visited[cur.R()]){
                    q.offer(new Register(cur.R(), cur.cmd+"R"));
                    visited[cur.R()] = true;
                }
            }//while
        }//test case
    }//main
}
