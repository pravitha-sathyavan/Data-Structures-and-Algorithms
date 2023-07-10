class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int profit =0;

        for(int i=1;i<n;i++){
            if(prices[i]-prices[i-1]>0)
              profit += prices[i]-prices[i-1];
        }

        return profit;
    }
}


// We will buy the stock at the previous price and sell it today to make a profit.
// If we repeat this for all such days (where the current price is higher than the previous day's price),
// we can add all the profits to get the total profit.
