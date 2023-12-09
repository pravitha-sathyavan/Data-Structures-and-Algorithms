
class Solve
{
    long project(long algoExperts[], long Developers[], int n)
    {
        long[] dp1 = new long[n-1];
        long[] dp2 = new long[n-1];
        
        dp1[0] = algoExperts[0]*Developers[0];
        for(int i=1;i<n-1;i++){
            dp1[i] = dp1[i-1] + algoExperts[i]*Developers[i];
        }
        dp2[n-2]= algoExperts[n-1] * Developers[n-2];
        for(int i=n-3;i>=0;i--){
            dp2[i] = dp2[i+1] + algoExperts[i+1] * Developers[i]; 
        }
        
        long[] result = new long[n];
        result[0] = dp2[0];
        for(int i=1;i<n-1;i++){
            result[i] = dp1[i-1]+dp2[i];
        }
        result[n-1] = dp1[n-2]; 
        long ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,result[i]);
        }
        return ans;
    }
}


