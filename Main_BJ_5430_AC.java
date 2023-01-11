import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_BJ_5430_AC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringBuilder sb = new StringBuilder();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
//            Deque<Character> q = new ArrayDeque<>();
            Deque<Integer> q = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");
            for(int i=0; i<n; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

//            안 되는 방법 : 배열에 들어갈 숫자는 최대 100이기 때문에 charAt을 사용해 끊으면 안 됨
//            30, 40이 3, 4로 끊겨 읽힘
//            String str = br.readLine();
//            for (int i = 1; i < str.length() - 1; i++) {
//                if (i % 2 == 1)
//                    q.offer(str.charAt(i));
//            }

            // deque의 앞을 보는지, 뒤를 보는지 : 앞이 true
            boolean flag = true;
            // error인지 아닌지
            boolean error = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') { // 뒤집기
                    flag = !flag;
                } else { //버리기
                    if (q.isEmpty()) {
                        error = true;
                        break;
                    }

                    if (flag)
                        q.poll();
                    else
                        q.pollLast();
                }
            }//for

            if (!error) {
                sb.append("[");
                int size = q.size();
                if (flag) {
                    for (int i = 0; i < size; i++) {
                        if (i == size - 1)
                            sb.append(q.poll());
                        else
                            sb.append(q.poll()).append(",");
                    }
//                    if(q.size()>0){
//                        sb.append(q.poll());
//                        while(!q.isEmpty()){
//                            sb.append(',').append(q.poll());
//                        }
//                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        if (i == size - 1)
                            sb.append(q.pollLast());
                        else
                            sb.append(q.pollLast()).append(",");
//
//                        if(q.size()>0){
//                            sb.append(q.pollLast());
//                            while(!q.isEmpty()){
//                                sb.append(',').append(q.pollLast());
//                            }
//                        }
                    }
                }

                sb.append("]").append("\n");
            }//if
            else
                sb.append("error").append("\n");

            System.out.print(sb);
        }//tc
    }//main
}