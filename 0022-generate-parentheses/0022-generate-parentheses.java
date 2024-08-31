class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, 0, 0, "", result);
        return result;
    }
    public void backtracking(int n, int numOpen, int numEnd, String str, List<String> result){
        if(numOpen == n && numEnd == n){
            result.add(str);
            return;
        }

        if(numOpen < n)
            backtracking(n, numOpen+1, numEnd, str+"(", result);
        if(numOpen > numEnd)
            backtracking(n, numOpen, numEnd+1, str+")", result);
    }
}