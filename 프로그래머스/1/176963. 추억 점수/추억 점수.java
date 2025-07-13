import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0; i<name.length; i++){
            hash.put(name[i], yearning[i]);
        }
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                String person = photo[i][j];
                if(hash.containsKey(person))
                    answer[i]+=hash.get(photo[i][j]);
            }
        }
        
        return answer;
    }
}