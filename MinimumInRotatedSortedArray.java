class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while(low < high){
                mid = (low + high)/2;
                if(high - low <= 1){
                  return Math.min(nums[low],nums[high]);
                }
                if(nums[low] > nums[mid]){
                    high = mid;
                }
                else if(nums[mid] > nums[high]){
                    low = mid;
                }
                else
                   return nums[0];
        }
        return nums[0];
    }
}
