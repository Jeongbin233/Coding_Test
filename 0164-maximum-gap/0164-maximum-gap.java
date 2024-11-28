class Solution {
    public int maximumGap(int[] nums) {
        int max = 0;
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            max = Math.max(max, nums[i+1]-nums[i]);
        }
        return max;
    }
}