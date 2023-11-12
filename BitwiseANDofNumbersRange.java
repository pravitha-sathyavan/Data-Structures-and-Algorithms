class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Bitwise AND will give a result which is less than or equal to smaller number
        while(right > left){
            right = right & (right-1);
        }
        return right;
    }
}

/* Desired Range: [5,12]

Starting from 12, the loop will first do
12 & 11 = 8

Next iteration, the loop will do
8 & 7 = 0

why did we skip anding of 10,9? Because even if we did so, the result would eventually be anded with 8 whose value would be lesser than equal to 8.

Hence, you start from the range end and keep working your way down the range till you reach the start.

*/
