
class Solution {
    public static int ValueOfSubarrays(int N, int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> temp2 = new ArrayList<>();
        for(int i=0;i<N;i++){
            List<Integer> temp = new ArrayList<>();
            temp2 = map.getOrDefault(arr[i],temp);
            temp2.add(i);
            map.put(arr[i],temp2);
        }
        long prev = -1;
        long value = 0;
        long mod = 1000000007;
        for(int i: map.keySet()){
            prev = -1;
            List<Integer> temp = new ArrayList<>();
             temp = map.get(i);
            if(temp.size()==1)
               continue;
            for(int j=0;j<temp.size()-1;j++){
                value += (temp.get(j)-prev)*(N-temp.get(j+1));
                prev = temp.get(j);
                value = value % mod;
            }
        }
        return (int)value;
    }
}
        
