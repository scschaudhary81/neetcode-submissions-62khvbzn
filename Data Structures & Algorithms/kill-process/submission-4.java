/*
Created Adjacency matrix for parent child graph and start killing from the node.
*/
class Solution {
    public void pKill(
        int process, HashMap<Integer, List<Integer>> edges, List<Integer> killedProcess) {
        if (edges.containsKey(process)) {
            for (int nextProcessToKill : edges.get(process)) {
                pKill(nextProcessToKill, edges, killedProcess);
            }
        }
        killedProcess.add(process); 
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        List<Integer> killedProcess = new ArrayList<>();
        for (int index = 0; index < pid.size(); index++) {
            int parent = ppid.get(index);
            int child = pid.get(index);
            if (parent == 0)
                continue;
            else {
                edges.putIfAbsent(parent, new ArrayList<>());
                edges.get(parent).add(child);
            }
        }
        pKill(kill, edges, killedProcess);
        return killedProcess;
    }
}
