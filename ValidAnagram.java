class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int slen = s.length();
        int tlen = t.length();
        if(slen!=tlen)
            return false;
        else{
            for(int i=0;i<slen;i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for(int i=0;i<tlen;i++){
                if(map.containsKey(t.charAt(i))){
                    int count = map.get(t.charAt(i));
                    if(count == 0)
                       return false;
                    map.put(t.charAt(i), count - 1);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
