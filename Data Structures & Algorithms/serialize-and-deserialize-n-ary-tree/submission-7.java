/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/*
Build the string like [node_value, child_count] + ........
For Deserialize use Queue to convert it to Tree Form with the use of dfs
*/

class Codec {
    // parse string to queue
    Queue<Pair<Node,Integer>> parser(String data){
        Queue<Pair<Node,Integer>> q = new LinkedList<>();
        String[] rawData = data.trim().split(" ");
        int root = 0;
        int child = 1;
        while(child < rawData.length){
            int val = Integer.parseInt(rawData[root]);
            int count = Integer.parseInt(rawData[child]);
            root+=2;
            child+=2;
            q.offer(new Pair(new Node(val),count)); 
        }
        return q;
    }
    // Encodes a tree to a single string
    public String serialize(Node root) {
       String current = "";
       if(root == null) return current;
       else{
         current = String.valueOf(root.val) + " " + String.valueOf(root.children.size()) + " ";
         for(Node next : root.children){
            current+=serialize(next);
         }
         return current;
       }
    }

    // build by dfs
    public Node buildDfs(Queue<Pair<Node,Integer>> q){
        if(q.size()==0) return null;
        else{
            Pair<Node,Integer> data = q.poll();
            Node current = data.getKey();
            int childCount = data.getValue();
            for(int i=1;i<=childCount;i++){
                current.children.add(buildDfs(q));
            }
            return current;
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<Pair<Node,Integer>> q = parser(data);
        return buildDfs(q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
