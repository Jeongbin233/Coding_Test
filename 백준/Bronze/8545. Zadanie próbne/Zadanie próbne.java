import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for(int i=str.length()-1; i>=0; i--){
            System.out.print(str.charAt(i));
        }
    }//main
}
