import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, (n-i)*arr[i]);
        }
        System.out.println(max);

    }//main
}
