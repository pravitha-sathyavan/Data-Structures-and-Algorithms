class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        if(n!=1 && k!=0){
           reverse(nums,0,n-1);
           reverse(nums,0,k-1);
           reverse(nums,k,n-1);
        }   
    }

    public void reverse(int[] nums, int start, int end)
    {   
        int temp;
        for(int i = start, j = end; i <= (start+end)/2; i++, j--){
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
