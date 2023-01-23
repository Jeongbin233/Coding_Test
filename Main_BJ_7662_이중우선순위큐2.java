import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_BJ_7662_이중우선순위큐2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i=0; i<k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I"))
                    map.put(num, map.getOrDefault(num, 0) + 1);

                else{
                    if(map.size() != 0){
                        int n;
                        if(num == 1) {
                            //TreeMap<>으로 선언해야 사용할 수 있다
                            n = map.lastKey();
                        }
                        else{
                            n = map.firstKey();
                        }

                        if(map.get(n) == 1)
                            map.remove(n);
                        else
                            map.put(n, map.get(n) - 1);
                    }//if
                }//else
            }
            if(map.size() == 0)
                System.out.println("EMPTY");
            else
                System.out.println(map.lastKey() + " " + map.firstKey());
        }//testcase
    }//main
}
