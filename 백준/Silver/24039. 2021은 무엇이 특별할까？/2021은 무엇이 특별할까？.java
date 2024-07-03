import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[10001];
        for(int i=2; i<=10000; i++)
            isPrime[i] = true;

        for(int i=2; i<=Math.sqrt(10000); i++){
            if(isPrime[i]){
                for(int j=i*i; j<=n; j+=i)
                    isPrime[j] = false;
            }
        }//for

        for(int i=2; i<100000; i++){
            for(int j=i+1; j<=10000; j++){
                if(isPrime[i] && isPrime[j]){
                    if(i * j <= n)
                        break;
                    else {
                        System.out.println(i * j);
                        System.exit(0);
                    }
                }
            }
        }



    }
}
