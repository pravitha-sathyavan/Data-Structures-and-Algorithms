class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>
                               (Collections.reverseOrder());
       int result = 0;
       for(int i=0;i<nums.length;i++)
            pq.offer(nums[i]);
       for(int i=0;i<k;i++){
            result = pq.poll();
       }
       return result;
    }
}
