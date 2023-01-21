import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_1764_듣보잡2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> people = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < n; i++)
            people.put(br.readLine(), 1);

        for(int i=0; i<m; i++){
            String name = br.readLine();
            people.put(name, people.getOrDefault(name, 0) + 1);
            if(people.get(name) == 2)
                arr.add(name);
        }

        Collections.sort(arr);
        System.out.println(arr.size());
        for(String s : arr){
            System.out.println(s);
        }

    }//main
}