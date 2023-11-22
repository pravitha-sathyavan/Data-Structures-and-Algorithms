class Solution{
    int longSubarrWthSumDivByK(int nums[], int n, int k)
    {
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int sum =0, modulus;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            modulus = sum %k;
            if(modulus<0)
              modulus += k;
            if(map.containsKey(modulus))
                count = ((i - map.get(modulus)) > count)? (i - map.get(modulus)) : count;
            if (!map.containsKey(modulus)) {
                 map.put(modulus, i);
            } 
        }
        return count;
    }
 
}
