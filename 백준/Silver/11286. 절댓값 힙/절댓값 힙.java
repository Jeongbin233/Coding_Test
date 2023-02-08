import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2))
                    return o1-o2;
                else
                    return Math.abs(o1)-Math.abs(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0 && pq.isEmpty()){
                sb.append(0+"\n");
            }
            else if(num==0 && !pq.isEmpty()){
                sb.append(pq.poll() +"\n");
            }
            else
                pq.offer(num);
        }
        System.out.println(sb);
    }//main
}
