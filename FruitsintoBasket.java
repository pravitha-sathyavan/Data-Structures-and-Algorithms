class Solution {
    public int totalFruit(int[] fruits) {
        int leftP = 0;
        int count = 0;
        int maxCount = -1;
        int index1, index2;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<fruits.length;i++){
            if(map.containsKey(fruits[i]) || map.size()<2){
                map.put(fruits[i],i);
                count++;
            }
            else if(map.size()==2){
                Integer[] types = map.keySet().toArray(new Integer[2]); 
                index1 = map.get(types[0]);
                index2 = map.get(types[1]);
                if(index1 < index2){
                    map.remove(types[0]);
                    leftP = index1+1;
                }
                else{
                    map.remove(types[1]);
                    leftP = index2+1;
                }
                map.put(fruits[i],i);
                count = i - leftP+1;
            }
            if(maxCount < count)
               maxCount = count;
        }
        return maxCount;
    }
}
