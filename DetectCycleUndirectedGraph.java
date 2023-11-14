
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean[] isVisited = new boolean[V];
       boolean result =false;
       for(int i=0;i<V;i++){
            if(!isVisited[i])
              result = dfs(adj,i,isVisited,-1);
              if(result)
                return result;
       }
       return false;
    }
    
    boolean dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] isVisited, int parent){
        if(isVisited[src]==true)
           return true;
           
        isVisited[src] =true;
        ArrayList<Integer> neighbours = adj.get(src);
        for(int i=0; i<neighbours.size();i++){
            if(neighbours.get(i)!=-1 && neighbours.get(i) != parent )
             if(dfs(adj,neighbours.get(i),isVisited,src))
                return true;
        }
        return false;
    }
}
