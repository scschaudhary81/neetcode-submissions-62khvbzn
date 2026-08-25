class Solution {
    static int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    HashSet<List<Integer>> distinctIslands;

    Solution(){
        distinctIslands = new HashSet<>();
    }
    public void browseIsland(
        int r,int c,int[][] grid,List<Integer>list,int startR,int startC
        ){
        if(r<0||c<0||r>=grid.length||c>=grid[0].length) return;
        else if(grid[r][c]==0) return;
        else{
            grid[r][c]=0;
            list.add(r-startR); list.add(c-startC);
            for(int[] direction : directions)  browseIsland(r+direction[0],c+direction[1],grid,list,startR,startC);
        }
    }
    public int numDistinctIslands(int[][] grid) {
    
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    List<Integer> currentIsland = new ArrayList<>();
                    browseIsland(r,c,grid,currentIsland,r,c);
                    distinctIslands.add(currentIsland);
                }
            }
        }
        return distinctIslands.size();
    }
}
