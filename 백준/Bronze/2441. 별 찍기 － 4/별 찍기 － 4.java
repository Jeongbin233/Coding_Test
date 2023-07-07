import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int s = a;
        for(int i=0; i<a; i++){
            for(int j=0; j<a-s; j++){
                System.out.print(" ");
            }
            for(int j=0; j<s; j++){
                System.out.print("*");
            }
            s--;
            System.out.println();
        }
    }//main
}
