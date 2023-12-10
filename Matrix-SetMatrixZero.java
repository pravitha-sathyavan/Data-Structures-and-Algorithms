/*
https://leetcode.com/problems/set-matrix-zeroes/

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int columnSize = matrix.length;
        int rowSize = matrix[0].length;
        boolean setColumnZero = false;
        boolean setRowZero = false;

        for(int i=0;i<columnSize;i++){
            if(matrix[i][0]==0){
              setColumnZero = true;
              break;
           }
        }
        for(int i=0;i<rowSize;i++){
           if(matrix[0][i]==0){
              setRowZero = true;
              break;
           }
        }

        for(int i=1;i<columnSize;i++){
            for(int j=1;j<rowSize;j++){
               if(matrix[i][j]==0){
                  matrix[i][0]=0;
                  matrix[0][j]=0;
           } 
         }
        }

        for(int i=1;i<rowSize;i++){
             if(matrix[0][i]==0){
              for(int j=1;j<columnSize;j++){
                matrix[j][i]=0;
           } 
        }
        }

        for(int i=1;i<columnSize;i++){
             if(matrix[i][0]==0){
              for(int j=1;j<rowSize;j++){
                matrix[i][j]=0;
           } 
        } 
    }

    if(setRowZero == true){
        for(int i=0;i<rowSize;i++)
          matrix[0][i]=0;
    }

    if(setColumnZero == true){
        for(int i=0;i<columnSize;i++)
          matrix[i][0]=0;
    }}
}
