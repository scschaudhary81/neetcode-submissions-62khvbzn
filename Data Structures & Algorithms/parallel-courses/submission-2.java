class Solution {

    public List<Integer>[] convertToAdj(int[][] relations,int n){
        List<Integer>[] adj = new List[n+1];
        for(int i=1;i<=n;i++) adj[i] = new ArrayList<>();
        for(int[] relation : relations){
            adj[relation[0]].add(relation[1]);
        }
        return adj;
    }
    public int traverse(int node,List<Integer>[] adj,int[] semesters){
        if(semesters[node] != 0) return semesters[node]; // if previous visited 
        else if(adj[node].size() == 0) return semesters[node] = 1; // if no outgoing node
        else{
            semesters[node] = -1;
            int semesters_from_current_node = 0;
            for(int next_node : adj[node]){
                int semesters_from_next_node = traverse(next_node, adj, semesters);
                if(semesters_from_next_node == -1){
                    semesters_from_current_node = -1;
                    break;
                }else{
                    semesters_from_current_node = Math.max(semesters_from_current_node,1+semesters_from_next_node);
                }
            }
            return semesters[node]=semesters_from_current_node;
        }
    }

    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] adj = convertToAdj(relations,n);
        int semesters_required = 0;
        int[] semesters = new int[n+1];

        for(int i=1;i<=n;i++){
            semesters[i] = traverse(i,adj,semesters);
        }

        // if i start at a given_node then required numbers of semester
        for(int semester : semesters){
            if(semester == -1){
                semesters_required = -1;
                break;
            }else{
                semesters_required = Math.max(semesters_required,semester);
            }
        }
        return semesters_required;
    }
}
