class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new CustomComparator()); 
        for(int index=0; index < points.length;index++){
            pq.add(points[index]);
        }
        int count = 0;
        while(count < k){
            result[count] = pq.poll();
            count++;
        }
        return result;
    }

    public class CustomComparator implements Comparator<int[]>{

        public int compare(int[] point1, int[] point2){
            if((point1[1]* point1[1] + point1[0]* point1[0]) > (point2[1]* point2[1] + point2[0]* point2[0]))
               return 1;
            else
               return -1;
        }
    }
}
