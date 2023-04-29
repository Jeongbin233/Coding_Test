import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if('A' <= str.charAt(i) && str.charAt(i) <='Z')
                sb.append(Character.toLowerCase(str.charAt(i)));
            else if('a' <= str.charAt(i) && str.charAt(i) <='z')
                sb.append(Character.toUpperCase(str.charAt(i)));
        }
        System.out.println(sb);
    }
}
