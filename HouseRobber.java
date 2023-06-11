class Solution {
    public int rob(int[] nums) {
  
      int n = nums.length;
      int money[] = new int[n];

      for(int i=n-1;i>=0;i--){
          if(i==n-1)
              money[i]=nums[i];
          else if(i == n-2)
              money[i]= max(nums[i],nums[i+1]);
          else if(i == n-3)
             money[i] = max(nums[i]+nums[i+2],nums[i+1]);
          else
            money[i] = max((nums[i] + money[i+2]),
                           (nums[i+1] + money[i+3]));
      }
      if(n>1)
      return max(money[0],money[1]);
      else
      return nums[0];
    } 

    int max(int a, int b)
    {
      if(a>b)
        return a;
      else
       return b;
    }   
}
