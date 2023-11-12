public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            // the condition should be n!=0 and not n>0 bc in java there is no unsigned integer type
            if((n & 1) == 1)
                count++;
            n = n>>>1;
            //>>> is unsigned-shift; it'll insert 0. >> is signed, and will extend the sign bit.
        }
        return count;
    }
}
