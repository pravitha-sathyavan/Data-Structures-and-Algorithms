class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = 
                new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1,List<Integer> l2) {
            return ((nums1[l1.get(0)]+nums2[l1.get(1)]) -(nums1[l2.get(0)]+nums2[l2.get(1)]));
    }}
    );
                  
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> ls = new ArrayList<Integer>();
        List<List<Integer>> result =   new ArrayList<>();
        if (n == 0 || m == 0) {
            return result;
        }       
        for(int i=0;i<Math.min(k, n);i++){
            pq.add(Arrays.asList(i,0));
        }
        for(int i=0;i<Math.min(k,n*m);i++){
            List<Integer> pair = pq.poll();
            if(pair.get(1)<m-1){
                pq.add(Arrays.asList(pair.get(0),pair.get(1)+1));
            }
            result.add(Arrays.asList(nums1[pair.get(0)],nums2[pair.get(1)]));
        }
        return result;
    }
}
