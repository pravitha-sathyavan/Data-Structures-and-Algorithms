
class Solution {
    public int maxSubArray(int[] nums) {
        int cSum = 0, maxSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            cSum += nums[i];
            if(maxSum<cSum)
                maxSum = cSum;
            if(cSum<0)
                cSum = 0;
        }
        return maxSum;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];
        for(int i=1;i< nums.length;i++){
            tempMax = (tempMax+nums[i] > nums[i])?tempMax+nums[i]:nums[i];
            max = tempMax>max?tempMax:max;
         }
        return max;        
    }
}


