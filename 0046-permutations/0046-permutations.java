class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        backtracking(rst, nums, new ArrayList<Integer>());
        return rst;
    }

    public void backtracking(List<List<Integer>> rst, int[] nums, List<Integer> list ){
        if(list.size() == nums.length){
            rst.add(new ArrayList<>(list));
            return;
        }

        for(int i: nums){
            if(!list.contains(i)){
                list.add(i);
                backtracking(rst, nums, list);
                list.remove(list.size()-1);
            }
        }

    }
}