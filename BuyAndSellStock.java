class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        if(prices.length == 1)
         return 0;
        int cp = prices[r] - prices[l];
        int mp;
        mp = cp>0?cp:0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=prices[l])
               l =i;
            if(prices[i]>=prices[r])
               r =i;
            if(r>l)
                cp = prices[r] - prices[l];
            else
                 r=l;
            if(cp>mp)
               mp = cp;
        }
        return mp;
    }
}
