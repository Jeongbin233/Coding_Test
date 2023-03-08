import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15657_N과M8 {

    static int n, m;
    static int[] arr;
    static int[] ans;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        visited = new boolean[n];
        ans = new int[m];
        perm(0, 0);
    }
    private static void perm(int index, int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
            return;
        }

        for(int i=index; i<n; i++){
            ans[cnt] = arr[i];
            perm(i, cnt+1);
        }
    }//perm
}
