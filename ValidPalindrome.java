class Solution {
    public boolean isPalindrome(String s) {
        for(int i=0, j=s.length()-1;i<s.length() && j>=0;){
                char x = s.charAt(i);
                char y = s.charAt(j);
                if(!Character.isLetterOrDigit(x))
                {
                    i++;
                }
                else if(!Character.isLetterOrDigit(y))
                {
                    j--;
                }
                else{
                    if(Character.toLowerCase(x)!=Character.toLowerCase(y))
                      return false;
                    else{
                        i++;j--;
                    }
                }
        }
        return true;
    }
}
