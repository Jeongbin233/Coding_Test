import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int index = c-'a';
            arr[index]++;
        }
        for(int i=0; i<26; i++)
            System.out.print(arr[i]+" ");
    }//main
}
