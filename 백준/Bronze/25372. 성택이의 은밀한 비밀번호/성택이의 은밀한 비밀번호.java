import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String str = sc.next();
            if(str.length()<6 || str.length()>9)
                System.out.println("no");
            else System.out.println("yes");
        }
    }//main
}
