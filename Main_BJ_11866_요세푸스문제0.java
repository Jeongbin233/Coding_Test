import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_11866_요세푸스문제0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++)
            q.add(i);

        sb.append("<");
        while(q.size()>1){
            for(int i=0; i<k-1; i++){
                q.add((q.poll()));
            }
            sb.append(q.poll()+", ");
        }
        sb.append(q.poll()+">");
        System.out.println(sb);
    }//main
}
