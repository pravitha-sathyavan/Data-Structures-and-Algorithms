class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        String str;
        for(int i=0;i<strs.length;i++){
            char array[] = strs[i].toCharArray();
            Arrays.sort(array);
            str = new String(array);
            List<String> newList = new ArrayList<>();
            newList = map.getOrDefault(str,newList);
            newList.add(strs[i]);
            map.put(str, newList);   
        }
       
        return new ArrayList<>(map.values());
    }
}
