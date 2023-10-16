class Solution {
    public int findPeakElement(int[] nums) {
      /* You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

      From the above point we can make the following conclusion:
      If nums[i-1] > nums[i] > nums[i+1] for all i,
      then we can search left part of i for peak element.
      If we are not getting any element then 1st element is peak element.
      Similarly for right part.
      In case if we find any peak element in bw, return it.
      */ 
      int n = nums.length;
      int low=1, high=n-2;
      int mid = 0;
      if(n==1)
          return 0;
      if(nums[0] > nums[1]) return 0;
      if(nums[n-1] > nums[n-2]) return n-1;   
      while(low <= high){
             mid = low + (high-low)/2;
          if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
             return mid;
          else if(nums[mid] < nums[mid+1]){
              low = mid+1;
          }else{
              high = mid-1;
          }
      }
      return mid;
    }
}
