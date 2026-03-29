
class Solution {
        /*
        In this problem statement we start with the trease index
        And move in all directions
        We stop when we visit water
        Or when we visit last that is near by to another treasure

        0(m*n)
        
        */
    public void traverse(int row,int col,int[][] grid,int distance){
        int m = grid.length;
        int n = m==0 ? 0 : grid[0].length;
        if(row<0 || row>=m || col<0 || col>=n) return;
        if( grid[row][col]== -1 || grid[row][col]<distance) return;

        grid[row][col]=distance;
        traverse(row+1,col,grid,distance+1);
        traverse(row-1,col,grid,distance+1);
        traverse(row,col+1,grid,distance+1);
        traverse(row,col-1,grid,distance+1);
    }
    public void islandsAndTreasure(int[][] grid) {
         int m = grid.length;
         int n = m==0 ? 0 : grid[0].length;
         for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0){
                    traverse(row,col,grid,0);
                }
            }
         }
    }
}
