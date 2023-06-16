import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int temp = 1;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '(') {
                stack.push(c);
                temp *= 2;
            }
            else if(c == '['){
                stack.push(c);
                temp *= 3;
            }
            else if(c == ')'){
                if(stack.isEmpty() || stack.peek()!='('){
                    sum = 0;
                    break;
                }
                if(str.charAt(i-1) == '(')
                    sum += temp;

                temp /= 2;
                stack.pop();

            }
            else{
                if(stack.isEmpty() || stack.peek()!='['){
                    sum = 0;
                    break;
                }
                if(str.charAt(i-1) == '[')
                    sum += temp;

                temp /= 3;
                stack.pop();
            }
        }//for
        if(stack.isEmpty())
            System.out.println(sum);
        else System.out.println(0);
    }//main
}
