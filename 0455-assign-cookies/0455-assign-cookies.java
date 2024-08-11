class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int content = 0;

        int done = 0;
        for(int i=0; i<s.length; i++){
            for(int j=done; j<g.length; j++){
                if(s[i] >= g[j]){
                    content++;
                    done = j + 1;
                    break;
                }
            }
        }

        return content;
    }
}