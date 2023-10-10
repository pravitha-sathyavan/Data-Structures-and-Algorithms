class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        Map<Character,Character> brackets = new HashMap<Character,Character>();
        Character x,c,a;
        brackets.put(')','(');
        brackets.put('}','{');
        brackets.put(']','[');

        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(!brackets.containsKey(c)){
                st.push(c);
            }
            else if(st.empty())
                return false;
            else {
               x = st.pop();
               if(brackets.getOrDefault(c,':')!=x){
                 return false;
               }
            }
        }
        if(st.empty())
            return true;
        else
           return false;
    }
}
