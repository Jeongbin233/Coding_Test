import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        int ans = 0;
        int cnt = 0;

        for(int i=1; i<s-1; i++){
            if(arr[i-1] == 'I' && arr[i]=='O' && arr[i+1] == 'I'){
                cnt++;

                if(cnt == n){
                    cnt--;
                    ans++;
                }

                i++;
            }
            else 
                cnt = 0;
        }

        System.out.println(ans);
    }//main
}
