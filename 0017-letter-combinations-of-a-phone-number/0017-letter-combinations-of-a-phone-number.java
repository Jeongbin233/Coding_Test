class Solution {
    public String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> result;
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();
        
        if(digits.length() > 0){
            comb(0, new StringBuilder(), digits.toCharArray());
        }
        return result;
    }
    
    public void comb(int pick, StringBuilder sb, char[] order){
        if(pick == order.length){
            result.add(sb.toString());
            return;
        }
        
        char[] charArr = letters[Character.getNumericValue(order[pick])].toCharArray();
        
        
        for(int i=0; i<charArr.length; i++){
            sb.append(charArr[i]);
            comb(pick+1, sb, order);
            sb.delete(sb.length()-1,sb.length());
        }
    }
}