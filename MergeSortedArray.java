class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1;
        int i,j;
        for(i = m-1, j = n-1; i >= 0 && j >= 0 ;){
            if(nums1[i] >= nums2[j]){
                nums1[last] = nums1[i];
                last--;
                i--;
            }
            else{
               nums1[last] = nums2[j];
               last--;
               j--;
            }
        }
        for(;j>=0;j--,last--){
            nums1[last] = nums2[j];
        }
}}
