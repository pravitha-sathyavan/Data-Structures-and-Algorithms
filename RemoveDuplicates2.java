class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int i;
        int n = nums.length;
        int count = 1;
        for(i = 1; i< n; ){
            if(nums[k] == nums[i] && count == 2){
               i++;
               count = 2;
            }
            else if(nums[k] == nums[i]){
                nums[k+1]=nums[i];
                i++;
                k++;
                count++;
            }
            else {
                nums[k+1] = nums[i];
                k++;
                i++;
                count = 1;
            }
        }
        return k+1;
    }
}
