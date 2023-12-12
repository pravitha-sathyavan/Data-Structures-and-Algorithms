/*

2461. Maximum Sum of Distinct Subarrays With Length K
Medium
1.1K
16
Companies
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
Example 2:

Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.
 

Constraints:

1 <= k <= nums.length <= 105
1 <= nums[i] <= 105
    
    */
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long cSum = 0, maxSum = 0;
        int leftP = 0, rightP = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for(int i=0; i<nums.length; i++){
            if(i!=0)
                 prefixSum[i] = prefixSum[i-1]+nums[i];

            if(map.containsKey(nums[i])){
                leftP = Math.max(map.get(nums[i])+1,leftP);
                cSum = prefixSum[i] - prefixSum[leftP-1];
            }else{
                cSum = cSum + nums[i];
            }
            rightP = i;
            map.put(nums[i],i);

            if(rightP - leftP == k - 1){
                if(maxSum<cSum){
                    maxSum = cSum;
                }
                cSum -= nums[leftP];
                map.remove(nums[leftP]);
                leftP++;
            }
        }

        return maxSum;
    }
}
