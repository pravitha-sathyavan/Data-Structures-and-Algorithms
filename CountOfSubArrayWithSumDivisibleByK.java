class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count =0, sum = 0,modulus;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            modulus = sum % k;
            if(modulus<0)
              modulus+=k;
            if(map.containsKey(modulus))
                count += map.get(modulus);
            map.put(modulus,map.getOrDefault(modulus,0)+1);
        }
        return count;
    }
}
