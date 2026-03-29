class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // tree must have n-1 edges

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        boolean[] visited = new boolean[n];
        if (!dfs(0, -1, graph, visited)) return false; // detect cycle

        // check connectivity: all must be visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private boolean dfs(int current, int parent, List<Integer>[] graph, boolean[] visited) {
        if (visited[current]) return false; // cycle detected
        visited[current] = true;

        for (int neighbor : graph[current]) {
            if (neighbor == parent) continue; // ignore edge back to parent
            if (!dfs(neighbor, current, graph, visited)) return false;
        }
        return true;
    }
}
