import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_11723_집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("all")){
                for(int j=0; j<21; j++){
                    map.put(j, 1);
                }
            }else if(command.equals("empty")){
                map.clear();
            }else{
                int num = Integer.parseInt(st.nextToken());
                switch (command){
                    case "add":
                        if(!map.containsKey(num))
                            map.put(num, 1);
                        break;
                    case "remove":
                        map.remove(num);
                        break;
                    case "check":
                        if(map.containsKey(num))
                            sb.append("1\n");
                        else
                            sb.append("0\n");
                        break;
                    case "toggle":
                        if(map.containsKey(num))
                            map.remove(num);
                        else
                            map.put(num, 1);
                        break;
                }//switch
            }
        }//for
        System.out.println(sb);
    }//main
}
