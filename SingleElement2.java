
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



/*
Given an unsorted array Arr of size N of positive integers. 
One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array. 
Find these two numbers.
*/

static void getTwoElements(int arr[], int n)
    {
        /* Will hold xor of all elements
       and numbers from 1 to n  */
        int xor1;

        /* Will have only single set bit of xor1 */
        int set_bit_no;

        int i;
        x = 0;
        y = 0;

        xor1 = arr[0];

        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];

        /* XOR the previous result with numbers from 
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;

        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);

        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same 
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The 
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];

            else
                /* arr[i] belongs to second set*/
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;

            else
                /* i belongs to second set*/
                y = y ^ i;
        }

        /* *x and *y hold the desired output elements */
    }

