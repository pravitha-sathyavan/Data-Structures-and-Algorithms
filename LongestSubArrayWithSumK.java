
//User function Template for Java

class Solution{
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
       int count =0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<N;i++){
            sum += A[i];
            if(map.containsKey(sum-K))
                count = ((i - map.get(sum-K)) > count)? (i - map.get(sum-K)) : count;
            if (!map.containsKey(sum)) {
                 map.put(sum, i);
            } 
        }
        return count;
    }
}
