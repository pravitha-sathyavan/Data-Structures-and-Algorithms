class pizza
{
    int maxPizza(int n, int[] arr)
        {
            int[] dp = new int[n];
            if(n==1)
                return arr[0];
            if(n==2)
                return Math.max(arr[0],arr[1]);
            if(n>2){
                dp[n-1]=arr[n-1];
                dp[n-2] = Math.max(arr[n-1],arr[n-2]);
                for(int i=n-3;i>=0;i--){
                    dp[i]=Math.max(arr[i]+dp[i+2],dp[i+1]);
                }
            }
            return dp[0];
        }
};
