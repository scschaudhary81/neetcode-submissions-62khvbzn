class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] visited;

    public Pair<Integer,Integer> findIsland(int r,int c,int[][] grid){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return null;
        else if(visited[r][c]) return null;
        else if(grid[r][c] == 0) return null;
        else{
            visited[r][c]=true;
            for(int[] direction : directions) findIsland(r + direction[0], c + direction[1],grid);
            return new Pair<>(r,c);
        }
    }


    public List<Pair<Integer,Integer>> findIslands(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        List<Pair<Integer,Integer>> islands = new ArrayList<>();
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Pair<Integer,Integer> island = findIsland(i,j,grid);
                if(island != null) islands.add(island);
            }
        }
        return islands;
    }


    public boolean isBothGraphEqual(int i,int j,int k,int l,int[][] grid,int m,int n){
        if( i<0 || j<0 || i>=m || j>=n ){
            return ( k<0 || l<0 || k>=m || l>=n ) || grid[k][l] == 0;
        }else if( k<0 || l<0 || k>=m || l>=n ){
            return ( i<0 || j<0 || i>=m || j>=n ) || grid[i][j] == 0;
        }
        else if(grid[i][j] == 0 && grid[k][l] == 0) return true;
        else if(grid[i][j] == 1 && grid[k][l] == 0) return false;
        else if(grid[i][j] == 0 && grid[k][l] == 1) return false;
        else{
            grid[i][j]=0;
            grid[k][l]=0;
            boolean isValid = true;
            for(int[] direction : directions){
                isValid  = isValid && isBothGraphEqual(i+direction[0],j+direction[1],k+direction[0],l+direction[1],grid,m,n);
            }
            grid[i][j]=1;
            grid[k][l]=1;
            return isValid;
        }
    }

    public int groupIslands(List<Pair<Integer,Integer>> islands,int[][] grid){
        int duplicate = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i < islands.size(); i++){
            for(int j = 0;j < i;j++){
               boolean areBothGraphEqual = isBothGraphEqual(
                islands.get(i).getKey(),
                islands.get(i).getValue(),
                islands.get(j).getKey(),
                islands.get(j).getValue()
                ,grid,m,n);
               if(areBothGraphEqual){
                duplicate++;
                break;
               }
            }
        }
        return islands.size() - duplicate;
    }



    public int numDistinctIslands(int[][] grid) {
        List<Pair<Integer,Integer>> islands = findIslands(grid);
        return groupIslands(islands,grid);
    }
}
