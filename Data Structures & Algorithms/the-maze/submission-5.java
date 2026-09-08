enum Direction{
    LEFT(0,-1),
    RIGHT(0,1),
    UP(-1,0),
    DOWN(1,0),
    NONE(0,0);

    int x;
    int y;

    Direction(int x,int y){
        this.x=x;
        this.y=y;
    }
};

class Solution {
    List<Direction> directions  = List.of(Direction.LEFT,Direction.RIGHT,Direction.UP,Direction.DOWN);


    public int[] moveToTillWall(int[] current,Direction direction,int[][] maze){
        int prevX = current[0];
        int prevY = current[1];
        int nextX = current[0];
        int nextY = current[1];
        while(nextX >= 0 && nextY >= 0 && nextX < maze.length && nextY < maze[0].length && maze[nextX][nextY] == 0){
            prevX = nextX;
            prevY = nextY;
            nextX = direction.x + nextX;
            nextY = direction.y + nextY;
        }
        return new int[]{prevX,prevY};
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> nodes = new LinkedList<>();
        boolean reached = false;
        if(maze[start[0]][start[1]] == 0){
            nodes.offer(start);
        }

        while(!nodes.isEmpty()){
            int[] current = nodes.poll();
            if(current[0] == destination[0] && current[1] == destination[1]){
                reached = true; break;
            }else if(visited[current[0]][current[1]]) continue;
            else{
                visited[current[0]][current[1]] = true;
                for(Direction direction : directions){
                    nodes.offer(moveToTillWall(current,direction,maze));
                }
            }
        }
        return reached;
    }
}
