import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 300;
        int b = 60;
        int c = 10;

        int t = sc.nextInt();

        if(t%c != 0)
            System.out.println(-1);
        else{
            int numA = 0;
            int numB = 0;
            int numC = 0;

            numA += t/a;
            t %= a;

            numB += t/b;
            t %= b;

            numC += t/c;
            t %= c;

            if(t != 0)
                System.out.println(-1);
            else System.out.println(numA + " " + numB + " " + numC);
        }


    }
}
