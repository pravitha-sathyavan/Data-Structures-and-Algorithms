class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int leftP = 0;
        long maxSum = 0;
        long sum = 0;
        int i = 0; 
        HashMap<Integer,Integer> map = new HashMap<>();

        for(i=0;i<nums.length;i++){
          if(k>0 && !map.containsKey(nums[i])){
                map.put(nums[i],i);
                sum = sum + nums[i];
                k--;
          }
          else if(k==0 && !map.containsKey(nums[i])){
                map.remove(nums[leftP]);
                map.put(nums[i],i);
                sum = sum - nums[leftP] + nums[i];
                leftP++;
          }
          else if(map.containsKey(nums[i])){
                int lastIndex = map.get(nums[i]);
                for(int j = leftP; j<= lastIndex; j++){
                    map.remove(nums[j]);
                    sum = sum - nums[j];
                    k++;
                }
                leftP = lastIndex+1;
                map.put(nums[i],i);
                sum = sum + nums[i];
                k--;
          }
          if(k==0 && maxSum < sum)
                maxSum = sum;   
           
        }

        return maxSum;
    }
}
