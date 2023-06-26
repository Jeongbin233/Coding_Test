import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int age = sc.nextInt();
        int weight = sc.nextInt();
        while (!(str.equals("#")&&age == 0&&weight==0)){
            if(age > 17 || weight >= 80)
                System.out.println(str + " Senior");
            else
                System.out.println(str + " Junior");
            str = sc.next();
            age = sc.nextInt();
            weight = sc.nextInt();
        }

    }//main
}
