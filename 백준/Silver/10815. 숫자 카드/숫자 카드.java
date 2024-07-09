import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] card = new boolean[20000001];
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            card[num+10000000] = true;
        }

        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int num = sc.nextInt();
            if(card[num+10000000] == true)
                System.out.print(1+" ");
            else System.out.print(0+" ");
        }
    }
}
