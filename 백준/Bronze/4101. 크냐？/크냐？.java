import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(a!=0 && b!=0){
            if(a>b)
                System.out.println("Yes");
            else
                System.out.println("No");

            a = sc.nextInt();
            b = sc.nextInt();
        }
    }//main
}
