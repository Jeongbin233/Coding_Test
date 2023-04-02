import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            pq.offer(Long.parseLong(st.nextToken()));

        int cnt = 0;
        while(cnt < m){
            long a = pq.poll();
            long b = pq.poll();
            pq.offer(a+b);
            pq.offer(a+b);

            cnt++;
        }

        long sum = 0;
        int size = pq.size();
        for(int i=0; i<size; i++)
            sum += pq.poll();
        System.out.println(sum);

    }//main
}
