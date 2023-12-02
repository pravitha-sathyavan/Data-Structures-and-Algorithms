class Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        int lenHayStack = haystack.length();
        int lenNeedle = needle.length();
        if(lenHayStack < lenNeedle)
            return index;
        if(haystack.equals(needle))
            return 0;
        for(int i=0;i<=(lenHayStack - lenNeedle);i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=1;
                int k=i+1;
                while(j<lenNeedle && haystack.charAt(k) == needle.charAt(j)){
                    k++;
                    j++;
                }
                if(j==lenNeedle)
                    return i;
            }
        }
        return index;
    }
}
