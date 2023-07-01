import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        int ah = h+c/60;
        int am = m+c%60;

        if(am >= 60){
            am -= 60;
            ah++;
            if(ah >= 24)
                ah %= 24;
        }
        else if(ah>=24)
            ah %= 24;
        
        System.out.println(ah+" "+am);
    }//main
}
