import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n != 0){
            System.out.println(n*(n+1)/2);
            n = sc.nextInt();
        }
    }//main
}
