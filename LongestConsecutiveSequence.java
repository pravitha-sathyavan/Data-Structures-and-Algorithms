class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        // Each element can be the starting point of consecutive sequence.
        //Initialize a map with each element and value true. Since we assume that each element can be a valid starting point.
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],true);
        }
        // If an element has its predecessor present, then its not a valid starting point. Set its value to false in this case.
        for(Map.Entry<Integer,Boolean> entry : map.entrySet()){
                if(map.containsKey(entry.getKey()-1))
                   map.put(entry.getKey(),false);
        }
        //Iterate through the map and if the value is true, iterate and find the length of longest consequence.
        int value;
        int count = 0,maxCount = 0;
        for (Map.Entry<Integer,Boolean> entry : map.entrySet()){
                if(map.get(entry.getKey())){
                    value = entry.getKey();
                    count = 1;
                    while((map.containsKey(value+1))){
                        count++;
                        value++;
                    }
                    if(maxCount<count)
                        maxCount = count;
                }
                
        }
    return maxCount;

    }
}
