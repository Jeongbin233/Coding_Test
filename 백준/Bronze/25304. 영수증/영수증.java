import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sum += a*b;
        }
        if(x == sum)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
