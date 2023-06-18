import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        while(!str.equals("#")){
            int sum = 0;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                c = Character.toLowerCase(c);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                    sum++;
            }
            sb.append(sum).append("\n");
            str = br.readLine();
        }
        System.out.println(sb);
    }//main
}
