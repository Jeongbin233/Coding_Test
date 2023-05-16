import java.util.Scanner;

public class Main {
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n];
        arr = new int[m];

        perm(n, m, 0);
    }
    private static void perm(int n, int m, int idx){
        if(idx == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<n; i++){
            if(visited[i])
                continue;

            visited[i] = true;
            arr[idx] = i+1;
            perm(n, m, idx+1);
            visited[i] = false;
        }
    }
}
