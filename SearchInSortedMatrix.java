class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i=0;
        int j=n-1;
        while(i<m && i>=0 && j<n && j>=0){
            if(matrix[i][j]==target)
              return true;
            if(matrix[i][j]<target){
                i=i+1;
            }
            else{
                j=j-1;
            }
        }
        return false;
        }
    }
