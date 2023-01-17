import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_BJ_1927_최소힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            } else {
                pq.offer(num);
            }
        }//for
    }//main
}
