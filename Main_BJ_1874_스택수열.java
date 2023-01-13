import java.util.Scanner;
import java.util.Stack;

public class Main_BJ_1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int index = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            while(stack.isEmpty() || stack.peek() < num) {
                stack.push(index++);
                sb.append("+\n");
            }
            if(stack.peek() == num){
                stack.pop();
                sb.append("-\n");
            }
            else{
                System.out.println("NO");
                System.exit(0);
            }

        }//for
        System.out.println(sb);
    }//main
}
