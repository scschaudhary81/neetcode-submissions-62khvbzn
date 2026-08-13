/**
Created Adjacency matrix for parent child graph and start killing from the node.
**/
class Solution {
    List<Integer> killedProcess = new ArrayList<>();

    public void pKill(int process, HashMap<Integer,List<Integer>> edges){
        killedProcess.add(process); // kill current process
        if(!edges.containsKey(process)) return; // skip killing child process of leaf node
        for(int nextProcessToKill : edges.get(process)){
            pKill(nextProcessToKill,edges);
        }
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer,List<Integer>> edges = new HashMap<>();

        for(int index = 0; index < pid.size() ; index++){
            int parent = ppid.get(index);
            int child = pid.get(index);
            if(parent == 0) continue;
            else{
                edges.putIfAbsent(parent,new ArrayList<>());
                edges.get(parent).add(child);
            }
        }
        pKill(kill,edges);
        return killedProcess;
    }
}
