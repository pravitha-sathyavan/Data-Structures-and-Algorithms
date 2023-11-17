

class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        dfs(grid, row, col, grid[row][col]);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]<0)
                   grid[i][j]=color;
            }
        }
        return grid;
    }

    public void dfs(int[][] grid,int i, int j, int color)
    {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = -color;
        if(i-1>=0 && grid[i-1][j]==color)
            dfs(grid, i-1,j,color);
        if(i+1<m && grid[i+1][j]==color)
            dfs(grid, i+1,j,color);
        if(j-1>=0 && grid[i][j-1]==color)
            dfs(grid, i,j-1,color);
        if(j+1<n && grid[i][j+1]==color)
            dfs(grid, i,j+1,color);
        if(i>0 && j>0 && i<m-1 && j<n-1 && 
            Math.abs(grid[i-1][j]) == color && Math.abs(grid[i+1][j]) == color
            && Math.abs(grid[i][j-1]) == color && Math.abs(grid[i][j+1]) == color )
              grid[i][j] = color;
    }
}

/*
The below solution works for 149/155 TCs.
class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(grid,visited,row,col,color);
        return grid;
    }


    public void dfs(int[][] grid, boolean[][] visited, int row, int col, int color){
        int val = grid[row][col];
        int m = grid.length;
        int n = grid[0].length;
        int count =0;
        if(visited[row][col])
            return;
        visited[row][col] = true;
        if(row-1>=0 && grid[row-1][col]==val){
            count++;
            dfs(grid, visited, row-1,col,color);
        }
        if(row+1<m && grid[row+1][col]==val){
            count++;
            dfs(grid, visited, row+1,col,color);
        }
        if(col-1>=0 && grid[row][col-1]==val){
            count++;
            dfs(grid, visited, row,col-1,color);
        }
        if(col+1<n && grid[row][col+1]==val){
            count++;
            dfs(grid, visited, row,col+1,color);
        }
        if(count<4)
           grid[row][col] = color; 
    }

}
*/
