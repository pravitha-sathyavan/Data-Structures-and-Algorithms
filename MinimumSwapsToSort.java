class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        int j,count,minSwap=0;
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                j =i;
                count = 0;
                while(!isVisited[j]){
                    isVisited[j] = true;
                    j = map.get(nums[j]);
                    count++;
                }
                if(count > 0)
                    minSwap += count-1;
            }
        }
        return minSwap;
    }
}
