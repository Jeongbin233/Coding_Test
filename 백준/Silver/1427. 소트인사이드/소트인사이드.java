import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int[] arr = new int[10];
        for(int i=0; i<n.length(); i++){
            char c = n.charAt(i);
            arr[(c-'0')]++;
        }
        for(int i=9; i>=0; i--){
            while(arr[i]>0) {
                System.out.print(i);
                arr[i]--;
            }
        }
    }
}
