import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(k).append("\n");
            k--;
        }
        System.out.print(sb);
    }//main
}
