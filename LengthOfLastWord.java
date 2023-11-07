class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int count = 0;
        int i;
        for(i= len-1;i>=0;i--){
            if(s.charAt(i)!=' ')
              break;
        }
        for(;i>=0;i--){
                if(s.charAt(i)==' ')
                   return count;
                else 
                  count++;
        }
        return count;
    }
}
