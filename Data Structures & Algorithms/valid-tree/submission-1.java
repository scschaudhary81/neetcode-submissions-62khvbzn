class Solution {
    // this the question to detect cycle in un directed graph



    public int noOfChildern(int current,int prev,List<Integer>[] graph,int[] memory){
        if(memory[current]!=0) return memory[current];
        else{
            int child=1;
            for(int to:graph[current]){
                if(prev==to) continue;
                child+=noOfChildern(to,current,graph,memory);

            }
            memory[current]=child;
            return child;
        }
    }


    public boolean dfs(int current,int prev,List<Integer>[] graph,boolean[] visited){
        if(visited[current]) return false;
        else{
            boolean result = true;
            visited[current]=true;
            for(int to : graph[current]){
                if(prev==to) continue;
                result =
                result && dfs(to,current,graph,visited);
            }
            visited[current]=false;
            return result;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        boolean allConnected=false;
        boolean[] visited = new boolean[n];
        List<Integer>[] graph = new List[n];

        int[] memory = new int[n];


        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }


        for(int i=0;i<n;i++){
            if(!dfs(i,-1,graph,visited)){
                return false;
            }
        }

        for(int i=0;i<n;i++){
            int current=noOfChildern(i,-1,graph,memory);
            if(current==n){
                allConnected=true;
                break;
            }
        }


        return allConnected;
    }
}
