import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 0;
        
        HashMap<Integer, Integer> hash = new LinkedHashMap<>();
        for(int num : tangerine){
            hash.put(num, hash.getOrDefault(num, 0)+1);
        }
        ArrayList<Integer> arr = new ArrayList(hash.values());
        Collections.sort(arr, Collections.reverseOrder());
        for(int i : arr){
            if(sum + i >= k){
                cnt++;
                break;
            }
            else{
                sum += i;
                cnt++;
            }
        }
        return cnt;
    }
}