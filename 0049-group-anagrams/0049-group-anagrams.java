class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String temp = strs[i];
            char[] arr = temp.toCharArray();
            Arrays.sort(arr);
            String ordered = new String(arr);

            if(map.containsKey(ordered)){
                map.get(ordered).add(temp);
            } else{
                map.put(ordered, new ArrayList<>());
                map.get(ordered).add(temp);
            }

        }
        return new ArrayList<>(map.values());
    }
}