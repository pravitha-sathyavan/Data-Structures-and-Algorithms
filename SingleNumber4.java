class Solution {
    public int[] singleNumber(int[] nums) {
       int xor = 0;
       for(int i=0;i<nums.length; i++){
           xor ^= nums[i];
       } 
       xor = xor & -xor;
       int[] results = new int[2]; 
       results[0] = 0;
       results[1] = 0;
       for(int i=0;i<nums.length;i++){
         // if((xor & nums[i]) == 1) wont work 
            if((xor & nums[i]) == 0) 
              results[0] ^= nums[i];
            else
              results[1] ^= nums[i];
       }
       return results;
    }
}
