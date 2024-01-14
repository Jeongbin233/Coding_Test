import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            trees[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(trees);

        int min = 0;
        int max = trees[n-1];
        while(min < max){
            int mid = (min + max) / 2;
            long sum = 0;
            for(int tree : trees){
                if(tree - mid > 0)
                    sum += tree-mid;
            }

            if(sum < m)
                max = mid;
            else
                min = mid+1;
        }//while

        System.out.println(min-1);
    }//main
}
