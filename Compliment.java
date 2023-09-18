class Solution {
    public int findComplement(int num) {
        // For 5 = 101, the ans = 010 i.e. 101 ^ 111. 
        // 111 is the required mask in this case
        // For calculating mask, we take the value of highest one bit
        // 5 = 101 in binary. Highest one bit = 100 returned by Integer highestOneBit(num)
        //If we left-shift this it will become 1000
        //1000 - 1 = 111 in binary that is the required mask
       return ((Integer.highestOneBit(num)<<1)-1) ^ num; 
    }
}
