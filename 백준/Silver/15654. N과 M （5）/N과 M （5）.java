import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, ans;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        ans = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0);
    }//main
    private static void perm(int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++){
                System.out.print(ans[i]+ " ");
            }
            System.out.println();
            return;
        }


        for(int i=0; i<n; i++){
            if(visited[i])
                continue;

            visited[i] = true;
            ans[cnt] = arr[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }//perm
}
