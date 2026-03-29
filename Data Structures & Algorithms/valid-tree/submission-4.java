class Solution {
    // to be  a tree graph needs to have two pre requisite
    // Not Nodes Should be connected
    // No Cycle should be present
    
    HashSet<Integer> set = new HashSet<>();
    boolean isConnected=false;
    boolean isValid(int current,int prev,List<Integer>[] graph,boolean[] visited){
        if(visited[current]) return false;
        else{
            boolean isTree=true;
            visited[current]=true;
            set.add(current);
            for(int to:graph[current]){
                if(to==prev) continue;
                isTree=isTree&&isValid(to,current,graph,visited);
            }
            return isTree;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }


        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            boolean isCycle = !isValid(i,-1,graph,visited);
            if(isCycle) return false;
            if(set.size()==n) isConnected=true;
            set = new HashSet<>();
        }
        return isConnected;
    }
}
