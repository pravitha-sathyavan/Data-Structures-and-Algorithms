class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] noOfPaths = new int[m][n];
        if(obstacleGrid[m-1][n-1]==1 || obstacleGrid[0][0] == 1)
          return 0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1)
                    noOfPaths[i][j] = 1;
                else if(obstacleGrid[i][j]==1)
                    noOfPaths[i][j]=0;
                else{
                    noOfPaths[i][j] = 0;
                    if(i+1<m)
                      noOfPaths[i][j] += noOfPaths[i+1][j];
                    if(j+1<n)
                      noOfPaths[i][j] += noOfPaths[i][j+1];
                }
            }
        }
        return noOfPaths[0][0]; 
    }
}
