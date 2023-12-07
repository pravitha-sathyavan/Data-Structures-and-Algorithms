
class Solution 
{ 
    void nextPermutation(int perm[], int N)
	{  
	int i = N - 2;
        while (i >= 0 && perm[i + 1] <= perm[i]) {
            i--;
        }
        if (i >= 0) {
            int j = N - 1;
            while (j >= 0 && perm[j] <= perm[i]) {
                j--;
            }
            int temp = perm[i];
            perm[i]=perm[j];
            perm[j]=temp;
        }
        i++;
        int end = N-1;
        while(i<end)
        {  
            int temp = perm[i];
            perm[i]=perm[end];
            perm[end]=temp;
            i++;end--;
            
        }
	}
} 
