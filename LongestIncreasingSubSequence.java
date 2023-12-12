 class LIS {
 
    // lis() returns the length of the longest
    // increasing subsequence in arr[] of size n
    static int lis(int arr[], int n)
    {
        int lis[] = new int[n];
        int i, j, max = 0;
 
        // Initialize LIS values for all indexes
        for (i = 0; i < n; i++)
            lis[i] = 1;
 
        // Compute optimized LIS values in
        // bottom up manner
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
 
        // Pick maximum of all LIS values
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];
 
        return max;
    }
 
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
 
        // Function call
        System.out.println("Length of lis is "
                           + lis(arr, n));
    }

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
