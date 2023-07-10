class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int i;
        int n = nums.length;
        for(i = 1; i< n; ){
            if(nums[k] == nums[i])
               i++;
            else{
                nums[k+1] = nums[i];
                k++;
                i++;
            }
        }
        return k+1;
    }
}
