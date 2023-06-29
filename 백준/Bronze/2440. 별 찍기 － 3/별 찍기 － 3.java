import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int s = n-i;
            for(int j=0; j<s; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }//main
}
