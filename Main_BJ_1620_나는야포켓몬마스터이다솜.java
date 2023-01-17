import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> nameHash = new HashMap<>();
        HashMap<Integer, String> indexHash = new HashMap<>();

        for(int i=1; i<=n; i++) {
            String name = br.readLine();
            nameHash.put(name, i);
            indexHash.put(i, name);
        }

        for(int i=0; i<m; i++){
            String check = br.readLine();
            //숫자이면
            if(Character.isDigit(check.charAt(0))){
                System.out.println(indexHash.get(Integer.parseInt(check)));
            }
            //문자열이면
            else{
                System.out.println(nameHash.get(check));
            }
        }


    }//main
}
