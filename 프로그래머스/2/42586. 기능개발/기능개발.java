import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0)
                q.add((100 - progresses[i]) / speeds[i]);
            else
                q.add((100 - progresses[i]) / speeds[i] + 1);
        }
        
        int x = q.poll();
        int cnt = 1;
        while(!q.isEmpty()){
            if(x>=q.peek()){
                cnt++;
                q.poll();
            }
            else{
                x = q.poll();
                list.add(cnt);
                cnt = 1;
            }
        }
        list.add(cnt);
        
        int[] answer = list.stream()
                        .mapToInt(i -> i)
                        .toArray();
        
        return answer;
        
    }
}