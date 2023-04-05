import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            ArrayList<Integer> arr = new ArrayList<>();
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int find = commands[i][2]-1;

            for(int idx=start; idx<=end; idx++){
                arr.add(array[idx]);
            }
            Collections.sort(arr);
            answer[i] = arr.get(find);
        }
        
        return answer;
    }// solution
}