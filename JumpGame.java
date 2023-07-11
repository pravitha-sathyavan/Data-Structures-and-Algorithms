class Solution {
    public boolean canJump(int[] nums) {
        int maxJumpfrombeg = 0;
        for(int i=0;i<=maxJumpfrombeg;i++){
            maxJumpfrombeg = Math.max(nums[i]+i,maxJumpfrombeg);
            if(maxJumpfrombeg >= nums.length - 1)
              return true;
        }
        return false;
    }
}
