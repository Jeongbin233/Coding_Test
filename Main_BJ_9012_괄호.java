import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_9012_괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int k=0; k<n; k++) {
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            boolean flag = false;
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '(')
                    stack.push(index);

                else {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        flag = true;
                        break;
                    } else
                        stack.pop();
                }
            }//for
            if(!flag){
                if(stack.isEmpty())
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }
}
