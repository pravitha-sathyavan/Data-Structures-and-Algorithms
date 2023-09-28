class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        int target;
        // Since we have duplicate elements in array, we cannot use map as 2 sum
        Arrays.sort(nums);

        for(int i =0;i<nums.length;i++){
            target = -nums[i];
            for(int j=i+1,k = nums.length - 1; j<k;){
                
                if(nums[j]+nums[k]==target){
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                       j++;
                       k--;
                }
                else if(nums[j]+nums[k] > target)
                    k--;
                else
                    j++;
            }
        }
        //Since we used set, we could avoid duplicate elements
        result.addAll(s);
        return result;
    }
}
