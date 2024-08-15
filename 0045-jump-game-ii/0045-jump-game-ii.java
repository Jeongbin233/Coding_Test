class Solution {
    public int jump(int[] nums) {
        int curMax = 0;
        int nextMax = 0;
        int cnt=0;
        for(int i=0; i<nums.length-1; i++){
            nextMax = Math.max(nextMax, i+nums[i]);
            if(i == curMax){
                curMax = nextMax;
                cnt++;
            }
        }
        return cnt;
        
    }
}