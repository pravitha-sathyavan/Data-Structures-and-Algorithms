import java.math.*;
class Solution {

    int fn(int[] nums, int currIndex, int prvsIndex, int dp[][]){
        int n = nums.length;
        int take = 0;
        int notTake = 0;
        if(currIndex == n)
          return 0;
        if(dp[currIndex][prvsIndex+1]!=-1)
           return dp[currIndex][prvsIndex+1];
        else if(prvsIndex == -1 || nums[currIndex]>nums[prvsIndex])
          take = 1 + fn(nums, currIndex + 1, currIndex, dp);
        notTake = fn(nums,currIndex+1,prvsIndex, dp);
        return dp[currIndex][prvsIndex+1] = Math.max(take,notTake);
    }

    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return fn(nums, 0, -1, dp);
    }
}
