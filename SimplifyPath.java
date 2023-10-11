class Solution {
    public String simplifyPath(String path) {
          Stack<String> st = new Stack<>();
          String[] splitPath = path.split("/");
          StringBuilder res = new StringBuilder();
          for(String dir: splitPath){
            // if we have . it means we're in the same folder. Continue
            // if we have "" it means we had a double slash //. Continue
              if(dir.equals("") || dir.equals("."))
                   continue;
              else if(dir.equals("..")) {
             // if we have .. only pop is stack is not empty
                   if(!st.isEmpty())
                     st.pop();
              }
              else 
                   st.push(dir);
          }
          if(st.isEmpty())
               return "/";
          for(String dir:st){
              res.append("/");
              res.append(dir);
          }
          return res.toString();
    }
}
