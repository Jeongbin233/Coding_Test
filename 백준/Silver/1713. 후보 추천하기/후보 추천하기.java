import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Info implements Comparable<Info>{
        int num;
        int cnt;
        int time;
        public Info(int num, int cnt, int time){
            this.num = num;
            this.cnt = cnt;
            this.time = time;
        }
        @Override
        public int compareTo(Info info){
            if(this.cnt==info.cnt)
                return this.time-info.time;
            else if(this.cnt<info.cnt)
                return -1;
            else return 1;
        }
    }//info

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Info> list = new LinkedList<>();
        for(int i=0; i<p; i++){
            int student = Integer.parseInt(st.nextToken());
            if(list.size() < n){
                boolean flag = false;
                for(int j=0; j<list.size(); j++){
                    if(list.get(j).num == student){
                        list.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    list.add(new Info(student, 1, i));
            }
            else {
                Collections.sort(list);
                boolean flag = false;
                for (int j = 0; j < list.size(); j++) {
                    //있을 때
                    if (list.get(j).num == student) {
                        list.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    list.remove(0);
                    list.add(new Info(student, 1, i));
                }
            }
        }

        int[] pic = new int[n];
        for(int i=0; i<list.size(); i++){
            pic[i] = list.get(i).num;
        }
        Arrays.sort(pic);
        for(int i=0 ;i<n; i++){
            if(pic[i] != 0)
                System.out.print(pic[i]+" ");
        }

    }//main
}
