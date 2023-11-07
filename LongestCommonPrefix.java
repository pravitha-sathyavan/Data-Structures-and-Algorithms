class Solution {
    public String longestCommonPrefix(String[] strs) {
            String common = strs[0];
            for(int i=1;i<strs.length;i++){
                common = findCommon(strs[i],common);
                if(common == "")
                    return "";
            }
            return common;
    }

    public String findCommon(String x, String y){
        String common = "";
        for(int i=0;i< x.length() && i< y.length();i++){
            if(x.charAt(i) == y.charAt(i))
               common += x.charAt(i);
            else
               return common;  
        }
        return common; 
    }
}
