import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for(int i=0; i<5; i++){
            int a = sc.nextInt();
            if(a>40)
                sum += a;
            else sum+=40;
        }
        System.out.println(sum/5);
    }//main
}
