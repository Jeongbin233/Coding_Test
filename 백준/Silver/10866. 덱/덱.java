import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens())
                num = Integer.parseInt(st.nextToken());

            switch (str){
                case "push_front":
                    q.offerFirst(num);
                    break;
                case "push_back":
                    q.offerLast(num);
                    break;
                case "pop_front":
                    if(q.size() > 0)
                        System.out.println(q.pollFirst());
                    else System.out.println(-1);
                    break;
                case "pop_back":
                    if(q.size() > 0)
                        System.out.println(q.pollLast());
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.size() > 0)
                        System.out.println(0);
                    else System.out.println(1);
                    break;
                case "front":
                    if(q.size() > 0)
                        System.out.println(q.peekFirst());
                    else System.out.println(-1);
                    break;
                case "back":
                    if(q.size() > 0)
                        System.out.println(q.peekLast());
                    else System.out.println(-1);
                    break;
            }
        }
    }//main
}
