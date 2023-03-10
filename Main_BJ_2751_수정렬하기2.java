import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_BJ_2751_수정렬하기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++)
            arr.add(sc.nextInt());
        Collections.sort(arr);

        for(int i=0; i<n; i++){
            if(i == 0)
                sb.append(arr.get(i) + "\n");
            else if(arr.get(i-1) != arr.get(i))
                sb.append(arr.get(i) + "\n");
        }
        System.out.println(sb);
    }
}
