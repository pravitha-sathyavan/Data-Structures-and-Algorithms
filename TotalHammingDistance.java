class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int count = 0;
        for(int bitPosition =0; bitPosition < 32;bitPosition++){
            count = 0;
            for(int index = 0;index <nums.length;index++){
        
                  count += (nums[index] >>> bitPosition)&1 ;
                //count += (nums[index]&(1 << bitPosition));
            }
            sum += count * (nums.length-count);
        }
        return sum;
    }
}
