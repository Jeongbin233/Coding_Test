import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class node{
        int loc;
        int w;

        public node(int loc, int w){
            this.loc = loc;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            LinkedList<node> q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                q.offer(new node(i, Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;
            while(!q.isEmpty()){
                node cur = q.poll();
                boolean isMax = true;

                for(int i=0; i<q.size(); i++){
                    if(cur.w < q.get(i).w){
                        q.offer(cur);
                        for(int j=0; j<i; j++)
                            q.offer(q.poll());

                        isMax = false;
                        break;
                    }
                }

                if(!isMax)
                    continue;

                cnt++;
                if(cur.loc == m)
                    break;
            }//while
            System.out.println(cnt);
        }//tc
    }//main
}
