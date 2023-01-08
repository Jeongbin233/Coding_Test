import java.util.*;
import java.io.*;

public class Main_BJ_2920_음계{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[8];
        for(int i=0; i<8; i++){
            int a = sc.nextInt();
            arr[i] = a;
        }

        boolean flag1 = false;
        boolean flag2 = false;

        for(int i=0; i<7; i++){
            if(arr[0] == 1 && arr[i]+1 == arr[i+1])
                flag1 = true;
            else{
                flag1 = false;
                break;
            }
        }
        for(int i=0; i<7; i++){
            if(arr[0] == 8 && arr[i]-1 == arr[i+1])
                flag2 = true;
            else{
                flag2 = false;
                break;
            }
        }
        if(flag1 == true)
            System.out.println("ascending");
        else if(flag2 == true)
            System.out.println("descending");
        else
            System.out.println("mixed");
    }

}