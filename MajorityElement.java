class Solution {
    public int majorityElement(int[] nums) {
        int majCan = nums[0];
        int majCount = 1;
        int i;
        int n = nums.length;
        for(i=1;i<n;i++)
        {
            if(majCan==nums[i])
                majCount ++;
            else
                majCount --;
            if(majCount==0){
                majCan = nums[i];
                majCount++;
            }
        }
        return majCan;
    }
}
