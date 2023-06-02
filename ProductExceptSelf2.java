class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];

        for(int i=0;i<length;i++){
            if(i==0)
              left[i] = 1;
            else
              left[i] = nums[i-1] * left[i-1];
        }
        

        for(int i=length-1;i>=0;i--){
            if(i==length-1)
              right[i] = 1;
            else
              right[i] = nums[i+1] * right[i+1];
        }

        for(int i=0;i<length;i++){
              output[i] = left[i]*right[i];
        }

    return output;
        
    }
}
