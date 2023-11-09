class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int currGas = 0;
        int startIndex = 0;
        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas<totalCost)
           return -1;
        for(int i=0;i<gas.length;i++){
            currGas += gas[i];
            if(currGas < cost[i]){
                currGas = 0;
                startIndex = i+1;
            }
            else{
                currGas -= cost[i];
            }
        }
        return startIndex;
    }
}
