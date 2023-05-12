import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String hospital = sc.next();
        if(str.length() < hospital.length())
            System.out.println("no");
        else System.out.println("go");
    }
}
