import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
      Scanner sc = new Scanner(System.in);
      while(sc.hasNext()){
          String str = sc.nextLine();
          if(!str.equals(""))
            System.out.println(str);
          else break;
      }

    }//main
}
