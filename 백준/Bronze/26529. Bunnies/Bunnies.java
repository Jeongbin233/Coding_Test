import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            int x = sc.nextInt();

            if (x == 0)
                System.out.println(1);
            else if(x == 1)
                System.out.println(1);
            else{
                long[] bunnies = new long[x+1];
                bunnies[0] = bunnies[1] = 1;
                for(int j=2; j<=x; j++){
                    bunnies[j] = bunnies[j-1] + bunnies[j-2];
                }
                System.out.println(bunnies[x]);
            }
        }
    }
}
