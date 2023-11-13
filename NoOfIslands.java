class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                   count++;
                   grid[i][j] = 2;
                   markVisited(grid,i,j); 
                }
            }
        } 
        return count;  
    }

    public void markVisited(char[][] grid,int x, int y){
        int m = grid.length;
        int n = grid[0].length;
        if(x-1>=0 && grid[x-1][y]=='1'){
            grid[x-1][y] = 2;
            markVisited(grid,x-1,y);
        }
        if(x+1<m && grid[x+1][y]=='1'){
            grid[x+1][y] = 2;
            markVisited(grid,x+1,y);
        }
        if(y-1>=0 && grid[x][y-1]=='1'){
            grid[x][y-1] = 2;
            markVisited(grid,x,y-1);
        }
        if(y+1<n && grid[x][y+1]=='1'){
            grid[x][y+1] = 2;
            markVisited(grid,x,y+1);
        }

    }
}
