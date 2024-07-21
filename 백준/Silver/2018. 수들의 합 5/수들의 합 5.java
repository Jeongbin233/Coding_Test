import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int start = 0; int end = 0;
        int sum = 0; int cnt = 0;

        while(start <= n){
            if(sum == n){
                cnt++;
                sum += end;
                end++;
            }

            if(sum < n){
                sum += end;
                end++;
            }

            if(sum > n){
                sum -= start;
                start++;
            }
        }

        System.out.println(cnt);
    }
}
