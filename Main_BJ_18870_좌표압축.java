import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_BJ_18870_좌표압축 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sorted[i] = num;
        }
        Arrays.sort(sorted);
        int rank = 0;
        for(int i : sorted){
            if(!map.containsKey(i)){
                map.put(i, rank);
                rank++;
            }
        }

        for(int i : arr){
            sb.append(map.get(i)+" ");
        }
        System.out.println(sb);
    }//main
}
