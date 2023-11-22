class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int bitPos=0; bitPos<32; bitPos++){
            int count = 0;
            for(int index = 0; index<nums.length; index++){
                count += ((nums[index] >>> bitPos)&1);
            }
            sum |= (count%3) << bitPos;
        }
        return sum;
    }
}
