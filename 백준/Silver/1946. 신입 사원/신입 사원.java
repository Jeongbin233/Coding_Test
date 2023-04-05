import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static class person implements Comparable<person>{
        int paper;
        int interview;

        public person(int paper, int interview){
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public int compareTo(person p){
            return this.paper-p.paper;
        }
    }//person

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc<t; tc++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<person> arr = new ArrayList<>();
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr.add(new person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(arr);

            // 이미 오름차순 정렬을 했기 때문에, 마지막으로 합격한 사람보다 인터뷰 순위가 작으면 무조건 합격!
            // 서류는 이미 이전사람보다 클 것이고, 인터뷰 순위마저 큰다면 조건에 위배가 된다.

            int ans = 1;
            // 처음은 서류1등 인터뷰 성적
            int min = arr.get(0).interview;
            // 서류 2등 친구부터
            for(int i=1; i<arr.size(); i++){
                // 만약 기준 등수 보다 살펴보는 친구의 등수가 높다면? -> 선발
                // 가장 최근에 채용된 지원자의 면접 순위보다 높은 지원자 찾기
                if(arr.get(i).interview < min){
                    // 기준 등수 갱신
                    min = arr.get(i).interview;
                    // 선발
                    ans++;
                }
            }//for

            // 시간초과 나는 코드
//            for(int i=1; i<arr.size(); i++){
//                for(int j=0; j<i; j++){
//                    if(arr.get(i).interview < arr.get(j).interview){
//                        ans++;
//                        break;
//                    }
//                }
//            }//for
            sb.append(ans+"\n");
        }//tc
        System.out.print(sb);
    }//main
}
