
//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
       /*First, calculate the XOR of all the array elements. 
        xor = arr[0]^arr[1]^arr[2].....arr[n-1]
        All the bits that are set in xor will be set in one non-repeating element 
        (x or y) and not in others. 
        So if we take any set bit of xor and divide the elements of the array in two sets 
        – one set of elements with same bit set and another set with same bit not set.
        By doing so, we will get x in one set and y in another set. 
        Now if we do XOR of all the elements in the first set, 
        we will get the first non-repeating element, and by doing same in other sets 
        we will get the second non-repeating element. */
        
        int res = 0;
        for(int i=0; i< nums.length; i++){
            res = res ^ nums[i];
        }
        // Get its last set bit
        res = res & -res;
        int rets[] = {0,0};
        
        for(int i=0; i< nums.length; i++){
            if((nums[i] & res)==0) // this bit is set
               rets[0] ^= nums[i];
            else // this bit is not set
               rets[1] ^= nums[i];
        }
        
         if(rets[0] > rets[1])
        {
            int temp=rets[0];
            rets[0]=rets[1];
            rets[1]=temp;
        }
        return rets;
     
    }
}
