class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      int size = s.length();
      boolean dp[] =  new boolean[size+1];
      dp[0] = true;
      String sub;
     
      for(int i=1; i <= size; i++){
            for(int j=0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
   if(dp[size]==true)
        return true;
      else
       return false;   
   }
}
