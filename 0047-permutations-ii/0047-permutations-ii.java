class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        perm(nums, visited, nums.length, new ArrayList<Integer>(), result);
        return result;
    }
    public void perm(int[] nums, boolean[] visited, int n, List<Integer> arr, List<List<Integer>> result){
        if(arr.size() == n){
            if(!result.contains(arr)){
                result.add(new ArrayList<Integer>(arr));
                return;
            }
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr.add(nums[i]);
                perm(nums, visited, n, arr, result);
                arr.remove(arr.size()-1);
                visited[i] = false;
            }
        }
    }
}