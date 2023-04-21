import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<k; i++){
            int n = sc.nextInt();
            if(n!=0)
                q.offer(n);
            else
                q.pollLast();
        }
        int ans = 0;
        while(!q.isEmpty()){
            ans+= q.poll();
        }
        System.out.println(ans);
    }//main

}
