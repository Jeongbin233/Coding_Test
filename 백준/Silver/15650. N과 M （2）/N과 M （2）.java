import java.util.Scanner;

public class Main {
    static int n;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n];

        permutation(0, 0, m);
    }//main
    private static void permutation(int cnt, int cur, int m){
        if(cnt == m){
            for(int i=0; i<n; i++){
                if(visited[i])
                    System.out.print(i+1 + " ");
            }
            System.out.println();
            return;
        }


        for(int i=cur; i<n; i++){
            if(visited[i])
                continue;

            visited[i] = true;
            permutation(cnt+1, i, m);
            visited[i] = false;
        }
    }//permutation
}
