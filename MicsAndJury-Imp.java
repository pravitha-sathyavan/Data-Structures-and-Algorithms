//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line1[0]);
            int M = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int teams[]= new int[M];
            for(int i = 0; i < M; i++)
                teams[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.micsandjury(N,M,teams));
        }
    }
}


// } Driver Code Ends


//Back-end complete function Template for Java

// Here we are assuming that the minimum posible solution is 1
// And the maximum possible solution is 1000 (as mentioned in qn max team size)
// Using binary search we are trying to find the range in which the solution can be present.
class Solution{
    static int micsandjury(int N,int M,int[] teams){
        int l = 1, r = 1000;
        int fans=1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            int groups =0;
            int i;
            
            for(i=0;i<M;i++)
            {
                if(teams[i]%mid!=0)
                groups+=teams[i]/mid+1;
                else
                groups+=teams[i]/mid;
            }
            if(groups>N)
            {
                l=mid+1;
            }
            else
            {
                
                fans = mid;
                r=mid-1;
            }
        }
        return fans;
    }
    
}
