class Solution {

    public boolean optimizeDfs(int index,int destination,HashSet<Integer>[] adj,boolean[] isVisited){
        if(index == destination) return adj[destination].size() == 0; // destination with no outgoing node
        else if(isVisited[index]) return false; // in current route no revisit
        else{
            isVisited[index] = true; // block this node in current route
            boolean isPossibleToReachDestination = adj[index].size() != 0;
             // if not desitnation then there should be outgoing node to reach destination
            for(int next : adj[index]){
                isPossibleToReachDestination = 
                isPossibleToReachDestination && optimizeDfs(next,destination,adj,isVisited);
                // every path should lead to destination
            }
            isVisited[index] = false; // unblock this node for next route
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
        // result
        boolean isValid = optimizeDfs(source,destination,adj,isVisited);

        return isValid;
    }
}
