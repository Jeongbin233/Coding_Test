class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int end = 0;
        
        for(int i=0; i<n; i++){
            int step = nums[i];
            end = Math.max(i+step, end);
            if(end>=n-1)
                return true;
            else if (end==i)
                return false;
        }
        return true;
    }
}