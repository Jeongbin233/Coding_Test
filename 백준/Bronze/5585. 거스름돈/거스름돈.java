import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int rest = 1000-money;
        int ans = 0;

        while(rest>0){
            if(rest/500 > 0) {
                ans+=rest/500;
                rest%=500;
            }
            else if(rest/100 > 0){
                ans+=rest/100;
                rest%=100;
            }
            else if(rest/50 > 0){
                ans+=rest/50;
                rest%=50;
            }
            else if(rest/10 > 0){
                ans+=rest/10;
                rest%=10;
            }
            else if(rest/5 > 0){
                ans+=rest/5;
                rest%=5;
            }
            else{
                ans+=rest;
                rest = 0;
            }
        }//while

        System.out.println(ans);
    }//main
}
