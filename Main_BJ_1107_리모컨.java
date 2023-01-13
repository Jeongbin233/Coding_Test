import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1107_리모컨 {
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        if(m>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                //고장난 버튼 체크
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // case 1. 원하는 채널까지 +,-버튼만으로 이동
        // 초기 채널 = 100. => 초기값 설정
        int ans = Math.abs(n - 100);

        // case 2. n과 근접한 수에서  +,-으로 채널 이동
        // 완탐. 0부터 999999까지 모든 채널을 돌며 가장 적은 횟수로 이동할 수 있는 채널 찾기
        for(int i=0; i<1000000; i++){
            int num = i;
            // isPossible: 0이면 불가능, 1이면 가능
            int len = isPossible(num);
            if(len > 0){
                // adj: 숫자 버튼으로 n에 최대한 인접한 수에서 +와 -를 몇 번 눌러야 하는지 구하는 수
                int adj = Math.abs(num - n);
                if(ans > len+adj)
                    ans = len + adj;
            }
        }
        System.out.println(ans);
    }//main
    private static int isPossible(int num){
        if(num == 0){ // 0일때 예외처리
            if(broken[0])
                return 0;
            else
                return 1;
        }

        // num의 자리수 체크
        int len = 0;
        while(num > 0){
            if(broken[num%10]) // 자리수 체크하다 불가능할 경우
                return 0;
            len++;
            num /= 10;
        }
        return len;
    }//isPossible
}
