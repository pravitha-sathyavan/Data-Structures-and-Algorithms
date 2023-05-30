class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        int prod = 1;
        int zeroFlag = 0;

        for(int i=0;i<length;i++){
            if(nums[i]==0)
              zeroFlag++;
            else
              prod = prod * nums[i];
        }

        for(int i=0;i<length;i++){
            if(nums[i]==0 && zeroFlag > 1)
              output[i] = 0;
            else if(nums[i]==0 && zeroFlag == 1)
              output[i] = prod;
            else if(zeroFlag != 0)
              output[i] = 0;
            else
              output[i] = prod/nums[i]; 
        }
    return output;     
    }
}
