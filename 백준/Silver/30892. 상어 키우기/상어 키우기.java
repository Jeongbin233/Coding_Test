import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        int [] sharks = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            sharks[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sharks);
        int cnt = 0;
        long size = t;
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        while(cnt < k){
            for(int i=idx; i<n; i++){
                if (sharks[i] < size) {
                    stack.add(sharks[i]);
                    idx = i+1;
                }
            }

            if(!stack.isEmpty()) {
                int temp = stack.pop();
                size += temp;
                cnt++;
            }
            else break;
        }

        System.out.println(size);

    }
}
