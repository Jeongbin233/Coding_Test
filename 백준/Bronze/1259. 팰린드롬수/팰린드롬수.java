import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        while(!n.equals("0")){
            boolean flag = true;
            for(int i=0; i<n.length()/2; i++){
                if(n.charAt(i) != n.charAt(n.length()-i-1)) {
                    flag = false;
                    break;
                }
            }
            if(!flag)
                System.out.println("no");
            else System.out.println("yes");
            n = sc.next();
        }
    }//main
}
