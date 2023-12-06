class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        long s1 = 0, s2 = 0;
        int i=0, j=0;
        for(; i<l1 && j<l2;){
            if(nums1[i]==nums2[j]){
                s1 = Math.max(s1,s2);
                s1 += nums1[i];
                s2 = s1;
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]){
                s1 += nums1[i];
                i++;
            }
            else{
                s2 += nums2[j];
                j++;
            }
            
        }
        if(i<l1){
            for(;i<l1;i++){
                s1 += nums1[i];
            }
        } 
        if(j<l2){
            for(;j<l2;j++){
                s2 += nums2[j];
            }
        } 
        return (int)((Math.max(s1,s2)) % 1000000007);
    }
}
