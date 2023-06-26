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
