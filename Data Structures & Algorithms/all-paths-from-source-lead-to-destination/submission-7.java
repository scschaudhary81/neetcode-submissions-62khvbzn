class Solution {

    public boolean dfs(int index,int destination,HashSet<Integer>[] adj,int[] isPossible){
        if(index == destination) return true;
        else if(isPossible[index] != 0) return isPossible[index] == 1;
        else{
            isPossible[index] = -1;
            boolean isAllPathPossibe = adj[index].size() != 0;
            for(int next : adj[index]){
                isAllPathPossibe = isAllPathPossibe && dfs(next,destination,adj,isPossible);
            }
            isPossible[index] = isAllPathPossibe ? 1 : -1;
            return isAllPathPossibe;
        }
    }

    public boolean optimizeDfs(int index,int destination,HashSet<Integer>[] adj,boolean[] isVisited){
        if(index == destination) return true;
        else if(isVisited[index]) return false;
        else{
            isVisited[index] = true;
            boolean isPossibleToReachDestination = adj[index].size() != 0;
            for(int next : adj[index]){
                isPossibleToReachDestination = 
                isPossibleToReachDestination && optimizeDfs(next,destination,adj,isVisited);
            }
            isVisited[index] = false;
            return isPossibleToReachDestination;
        }
    }
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {  
        // state
        boolean[] isVisited = new boolean[n];
        // create adjacency matrix
        HashSet<Integer>[] adj = new HashSet[n];
        for(int i=0;i<n;i++) adj[i] = new HashSet<>();
        for(int[] edge : edges) adj[edge[0]].add(edge[1]);
        // visited for detecting cycle
        boolean[] visited = new boolean[n];
        // Queue
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        // result
        boolean isValid = adj[destination].size() == 0 
        && optimizeDfs(source,destination,adj,isVisited);

        return isValid;
    }
}
