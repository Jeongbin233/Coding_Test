import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2001];
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            arr[a+1000]++;
        }
        for(int i=0; i<=2000; i++) {
            if(arr[i] > 0)
                System.out.print(i-1000+" ");
        }
    }
}
