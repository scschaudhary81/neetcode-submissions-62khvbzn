/*
1. Do dfs
2. Count no of times you have to do dfs so that all nodes are visited
*/
class Solution {
    public void dfs(int current,boolean[] visited,List<Integer>[] graph){
        if(visited[current]) return;
        else{
            visited[current]=true;
            for(int to:graph[current]){
                dfs(to,visited,graph);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
            List<Integer>[] graph = new List[n];
            for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
            for(int[] edge : edges){
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            int count = 0;
            boolean[] visited = new boolean[n];
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    count++;
                    dfs(i,visited,graph);
                }
            }


            return count;
    }
}
