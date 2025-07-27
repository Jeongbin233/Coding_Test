import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i=0; i<discount.length - days + 1; i++){
            HashMap<String, Integer> dmap = new HashMap<>();
            for(int j=0; j<days; j++){
                dmap.put(discount[i+j], dmap.getOrDefault(discount[i+j], 0) + 1);
            }
            
            Boolean isIdentical = true;
            for(String key : map.keySet()){
                if(map.get(key) != dmap.get(key)){
                    isIdentical = false;
                    break;
                }
            }
            
            if(isIdentical)
                answer += 1;
        }
        
        return answer;
    }
}