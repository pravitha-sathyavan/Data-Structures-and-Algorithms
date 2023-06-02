class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
    

        for(int i=0;i<length;i++){
            if(i==0)
              output[i] = 1;
            else
              output[i] = nums[i-1] * output[i-1];
        }
        
        int right_Product = nums[length-1];
        for(int i=length-2;i>=0;i--){
              output[i] = output[i] * right_Product;
              right_Product = right_Product * nums[i];
        }

    return output;      
    }
}
