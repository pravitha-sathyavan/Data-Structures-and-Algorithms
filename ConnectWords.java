//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t>0)
		{
		    int n = Integer.parseInt(br.readLine().trim());
		    Set<String> s = new HashSet<>();
		    for(int i=0;i<n;i++)
		    {
		        String words = br.readLine().trim();
		        s.add(words);
		    }
			String start = br.readLine().trim();
			String target = br.readLine().trim();
			Solution T = new Solution();
			System.out.println(T.wordLadderLength(start,target,s));
			t--;
		}
	}
	
}

// } Driver Code Ends

//Back-end complete function Template for Java

public class Solution {
    public int wordLadderLength(String start, String target, Set<String> dictionary) {
        
        // If the word to be formed is
        // not in the dictionary
        if(!dictionary.contains(target))
        {
            return 0;
        }
        
        // If the both the starting and final
        // words are the same
        if(start.equals(target)) return 2;
        
        // Store the words that are formed
        Queue<String> q = new LinkedList<String>();
        // Store the steps required to reach respective words
        Queue<Integer> q2 = new LinkedList<Integer>();
        q.add(start);
        q2.add(1);
 
        while(!q.isEmpty())
        {
            String word = q.remove();
            int steps = q2.remove();
            
            // If the word is same
            // as the final word
            if(word.equals(target))
            {
                return steps;
            }
            
            // Store the characters of the 
            // word in an array
            char[] orig_c = word.toCharArray();
            
            // Traverse the length of the word
            for(int pos=0; pos<word.length(); pos++)
            {
                for(char c='a'; c<='z'; c++)
                {
                    char temp = orig_c[pos];
                    
                    // Replace every position of the
                    // word with all the alphabets
                    // to generate new words
                    if(orig_c[pos]!=c)
                    {
                        orig_c[pos]=c;
                    }
 
                    String new_word = new String(orig_c);
                    // If the word formed is present 
                    // in the dictionary
                    if(dictionary.contains(new_word))
                    {
                        q.add(new_word);
                        
                        q2.add(steps + 1);
                        // Remove it from the dictionary
                        dictionary.remove(new_word);
                    }
 
                    // Restore back to original string
                    orig_c[pos]=temp;
                }
            }
        }
 
        return 0;
    }
}


/*

Your DFS algorithm is probably eliminating the optimal path due to the visited nodes list. 
(Cyclic and non directed nature of the problem.)
Inorder to avoid cycles (infiinte loop), dp algorithm would end up with a solution that is not optimal.

Consider the graph in the picture
Source is hbo
Target is qbx.
Words ["abo","hbw","abq","qbq","qbx","qbw"]

DP algoritm first chooses the path (PATH1) hbo->abo->abq->qbq->qbw->hbw

At this state, it would try to make the next move hbw->qbw, but it wont be able to because qbw is already visited in this path. So the dp algorithm would determine that there are no ways to reach the target(qbx) from hbw.

So later when the algorithm attempts to make the optimal PATH 2 hbo->hbw->qbw->qbx, the process is cut off at the node hbw, as PATH1 determined that you cant reach the target from hbw.

So it would endup choosing some other non optimal path like PATH 3 hbo->abo->abq->qbq->qbx.


Just get the job done with BFS here.

Note: DFS without memoization would give the the optimal path but time complexity would be exponential.

class Solution {
    public int wordLadderLength(String start, String target, Set<String> D) {
        if(!D.contains(target))
            return 0;
        if(start.equals(target))
            return 2;
        int len = D.size();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String x:D){
            List<String> list = new ArrayList<>();
            for(String y:D){
                if(findDiff(x,y)==1)
                    list.add(y);
            }
            map.put(x,list);
        }
        List<String> list = new ArrayList<>();
        list = map.getOrDefault(start,list);
        for(String x:D){
            if(findDiff(start,x)==1){
                list.add(x);
            }
            map.put(start,list);
        }
        System.out.println(map);
        HashMap<String,Boolean> isVisited = new HashMap<>();
        int ans = dfs(start,target,map,isVisited);
        if(ans == 1000000)
           ans = 0;
        return ans;
    }
    
    public int dfs(String start, String target, HashMap<String,List<String>> map,HashMap<String,Boolean> isVisited){
        System.out.println(start);
        if(start.equals(target))
            return 1;
        int min = 1000000, len = 0;
        List<String> list = map.get(start);
        isVisited.put(start,true);
        for(int i=0;i<list.size();i++){
            if(isVisited.getOrDefault(list.get(i),false)!=true){
                len = 1+ dfs(list.get(i),target,map,isVisited);
                if(len<min)
                    min = len;
            }   
        }
        System.out.println(min);
        return min;
    }
    
    
    
    public int findDiff(String start, String target){
        int len = start.length();
        int diff = 0;
        for(int i=0;i<len;i++){
            if(start.charAt(i)!=target.charAt(i)){
                diff++;
                if(diff > 1)
                   return diff;
            }
        }
        return diff;
    }
}

*/
