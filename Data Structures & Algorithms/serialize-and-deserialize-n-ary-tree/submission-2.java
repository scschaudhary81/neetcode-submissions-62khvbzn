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

class Codec {
    Stack<Node> nodes = new Stack<>();
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        String current = "";
        if(root == null) return current;
        else{
            current+=String.valueOf(root.val) +" ";
            if(root.children.size() > 0){
                current+="[";
                for(Node child : root.children){
                    current+=serialize(child);
                }
                current+="]";
            }
            return current;
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Node root = null;
        Node prev = null;
        String currentString = "";
        for(char c : data.toCharArray()){
            if(c=='['){
                if(prev != null) nodes.push(prev);
            }else if(c==']'){
                if(!nodes.isEmpty()) nodes.pop();
            }else if(c==' '){  
                Node current = new Node(Integer.parseInt(currentString));
                if(root == null) root = current; // if no firstNode
                prev = current; // update the previous node
                if(!nodes.isEmpty()) nodes.peek().children.add(current); // add it as child of previous node
                currentString = "";
                System.out.println(current.val);
            }else{
                currentString+=c;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
