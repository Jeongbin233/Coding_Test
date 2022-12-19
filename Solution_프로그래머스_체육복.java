import java.util.*;
import java.io.*;

class Solution_프로그래머스_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        // int ans = n - lost.length + reserve.length;
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = 1;
        }
        for(int i=0; i<lost.length; i++){
            arr[lost[i]]--;
        }
        for(int i=0; i<reserve.length; i++){
            arr[reserve[i]]++;
        }

        for(int i=1; i<n; i++){
            if(arr[i]==0){
                if(arr[i-1]==2){
                    arr[i-1]=1;
                    arr[i]=1;
                }
                else if(arr[i+1]==2){
                    arr[i+1]=1;
                    arr[i]=1;
                }
                else
                    continue;
            }
        }

        if(arr[n]==0){
            if(arr[n-1]==2){
                arr[n-1]=1;
                arr[n]=1;
            }
        }


        int ans = 0;
        for(int i=1; i<=n; i++){
            if(arr[i]>=1)
                ans++;
        }
        return ans;

    }
}