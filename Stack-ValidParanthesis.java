/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type. 
*/
    
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
