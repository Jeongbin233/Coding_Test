import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for(int i=0; i<n; i++){
            HashMap<Character, Integer> map = new HashMap<>();
            String str = sc.next();
            char c = str.charAt(0);
            Boolean flag = true;
            for(int j=1; j<str.length(); j++){
                char s = str.charAt(j);
                if(c == s)
                    map.put(s, map.getOrDefault(s, 0)+1);

                else{
                    if(map.containsKey(s)) {
                        flag = false;
                        break;
                    }
                    else map.put(c, 1);

                    c = s;
                }
            }
            if(flag)
                cnt++;
        }
        System.out.print(cnt);
    }//main
}
