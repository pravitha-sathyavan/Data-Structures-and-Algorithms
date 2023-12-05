//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    long solve(int V,int E,int[] Values,int[][] Edges){
        HashMap<Integer,List<Integer>> adjacencyList = new HashMap<>();
        for(int i=0;i<E;i++){
           List<Integer> list1 = new ArrayList<>();
           list1 = adjacencyList.getOrDefault(Edges[i][0],list1);
           list1.add(Edges[i][1]);
           adjacencyList.put(Edges[i][0],list1);
           List<Integer> list2 = new ArrayList<>();
           list2 = adjacencyList.getOrDefault(Edges[i][1],list2);
           list2.add(Edges[i][0]);
           adjacencyList.put(Edges[i][1],list2);
        }
        
        long sum = 0, maxSum = 0;
        Boolean[] isVisited = new Boolean[V];
        Arrays.fill(isVisited,false);
        for(int i=0;i<V;i++){
            if(isVisited[i]==false){
                sum = dfs(adjacencyList,isVisited,i+1,Values);
                if(sum>maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }
    
    long dfs(HashMap<Integer,List<Integer>> adjacencyList,Boolean [] isVisited, int v,int[] Values){
        List<Integer> neighbours = new ArrayList<Integer>();
        neighbours = adjacencyList.getOrDefault(v,neighbours);
        isVisited[v-1] = true;
        long sum = Values[v-1];
        for(int i=0;i<neighbours.size();i++){
            if(isVisited[neighbours.get(i)-1]!=true){
                sum += dfs(adjacencyList,isVisited,neighbours.get(i),Values);
            }
        }
        return sum;
    }
    
    
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int V = sc.nextInt();
            int E= sc.nextInt();
            int[] Values= new int[V];
            for(int i=0;i<V;i++)
                Values[i]=sc.nextInt();
            int[][] Edges=new int[E][2];
            for(int i=0;i<E;i++)
            {
                Edges[i][0]=sc.nextInt();
                Edges[i][1]=sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.solve(V,E,Values,Edges));
        }
    }
}

// } Driver Code Ends
