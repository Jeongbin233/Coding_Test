import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int next = n;
        int cnt = 0;
        while(true){
            int ten = next/10;
            int one = next%10;
            next = one*10 + (ten+one)%10;
            cnt++;

            if(next == n)
                break;
        }
        System.out.println(cnt);
    }
}
