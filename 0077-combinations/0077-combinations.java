class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        backtracking(1, n, k, rst, new ArrayList<>());
        return rst;
    }
    public void backtracking(int start, int n, int k, List<List<Integer>> rst, List<Integer> list){
        if(list.size() == k){
            rst.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<=n; i++){
            list.add(i);
            backtracking(i+1, n, k, rst, list);
            list.remove(list.size()-1);
        }
    }
}