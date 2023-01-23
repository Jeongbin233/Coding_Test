import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_7662_이중우선순위큐 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            StringBuilder sb = new StringBuilder();
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minq = new PriorityQueue<>();
            PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<k; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")){
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    minq.offer(num);
                    maxq.offer(num);
                }
                else {
                   if(map.size() != 0){
                       if(num == 1)
                           removeMap(maxq, map);
                       else
                           removeMap(minq, map);
                   }
                }
            }//k만큼

            if(map.size() == 0)
                sb.append("EMPTY\n");
            else{
                //큰 값
                int n = removeMap(maxq, map);
                sb.append(n+" ");

                //작은 값
                if(map.size() != 0){
                    int m = removeMap(minq, map);
                    sb.append(m+"\n");
                }
                else
                    sb.append(n+"\n");
            }
            System.out.print(sb);
        }//testcase
    }//main
    private static int removeMap(PriorityQueue<Integer> pq, HashMap<Integer, Integer> map){
        int num;
        while(true){
            num = pq.poll();
            int cnt = map.getOrDefault(num, 0);

            if(cnt == 0)
                continue;

            else if(cnt == 1)
                map.remove(num);

            else
                map.put(num, cnt-1);

            break;
        }//while
        return num;
    }//removeMap
}
