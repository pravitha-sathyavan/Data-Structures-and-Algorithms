class Solution {
    public int subarraySum(int[] nums, int k) {
        /* BruteForce Approach: Find all subarrays and check if any of sum = k i.e O(n^2)
        Efficient Approach: O(n)
        AIM: check if subarraySum = k;
        How to find subarray sum efficiently?
        Find accumulated subarray sum and take the difference.
            sum[0]=0;
            for (int i = 1; i <= nums.length+1; i++)
                sum[i] = sum[i - 1] + nums[i - 1];
        Find the subarray sum between index start and end
            sumOfSubarray = sum[end] - sum[start]; 

        In this qn we need to find count of
            sumOfSubarray = k
            sum[end] - sum[start] = k;
          =>sum[end] - k = sum[start];

        */
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
