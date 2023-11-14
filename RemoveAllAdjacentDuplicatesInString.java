class Solution {
    public String removeDuplicates(String s) {
        String result;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            stack.add(s.charAt(i));
            stack = processAdjacent(stack);
        }
        return stack.stream().map(x -> x.toString()).collect(Collectors.joining(""));
    }

    Stack<Character> processAdjacent(Stack<Character> stack){
        int n = stack.size();
        if(n>1){
            int i=n-1;
            while(i-1>=0 && stack.elementAt(i)==stack.elementAt(i-1)){
                stack.pop();
                i--;
            }
            if(i!=n-1)
               stack.pop();
        }
        return stack;
    }
}
