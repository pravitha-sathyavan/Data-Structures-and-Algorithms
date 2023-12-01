class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int[] result = new int[2];
        boolean[] deadline = new boolean[n+1];
        Arrays.sort(arr, (first, second) -> (second.profit - first.profit));
        for(int i=0;i<n;i++){
            int allotedTime = arr[i].deadline;
            while(allotedTime > 0 && deadline[allotedTime])
            {
                allotedTime--;
            }
            if(allotedTime!=0){
                deadline[allotedTime] = true;
                result[0]++;
                result[1] += arr[i].profit;
            }
        }
        return result;
    }
}

// class Job {
//     int id, profit, deadline;
//     Job(int x, int y, int z){
//         this.id = x;
//         this.deadline = y;
//         this.profit = z; 
//     }
// }
