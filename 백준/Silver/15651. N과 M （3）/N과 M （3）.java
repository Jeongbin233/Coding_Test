import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pick = new int[m];
        perm(0);
        System.out.println(sb);
    }
    private static void perm(int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++){
                sb.append(pick[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            pick[cnt] = i+1;
            perm(cnt+1);
        }

    }//perm
}
