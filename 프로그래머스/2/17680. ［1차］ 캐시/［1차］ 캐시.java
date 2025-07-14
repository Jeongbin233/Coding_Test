import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length * 5;
        
        int time = 0;
        LinkedList<String> cache = new LinkedList<>();
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();
            if(!cache.remove(city)){
                time += 5;
                if(cache.size() >= cacheSize)
                    cache.remove(0);
                cache.add(city);
            }
            else {
                time += 1;
                cache.add(city);
            }
        }
        return time;
    }
}