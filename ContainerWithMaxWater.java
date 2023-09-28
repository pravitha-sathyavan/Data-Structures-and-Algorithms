class Solution {
    public int maxArea(int[] height) {
        int l,r;
        int currWater = 0, maxWater = 0;

        for(l=0,r = height.length-1;l<height.length&&r>=0;){
            int h = Math.min(height[l],height[r]);
            currWater = h * (r-l);
            if(currWater > maxWater)
                maxWater = currWater;
            if(height[l]<height[r])
               l++;
            else
               r--;
        }
        return maxWater;
    }
}
