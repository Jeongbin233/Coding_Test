import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        perm(0, 0);
    }//main
    private static void perm(int cnt, int index){
        if(cnt == m){
            for(int i=0; i<m; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }

        for(int i=index; i<n; i++){
            arr[cnt] = i+1;
            perm(cnt+1, i);
        }
    }//perm
}
