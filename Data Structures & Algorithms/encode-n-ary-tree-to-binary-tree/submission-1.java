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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {

    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        else{
            TreeNode current = new TreeNode(root.val);
            TreeNode prevChild = null;
            for(Node child : root.children){
                TreeNode treeChild = encode(child);
                if(prevChild == null)  current.left = treeChild;
                else prevChild.right = treeChild;
                prevChild = treeChild;
            }
            return current;
        }
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;
        else{
            Node node = new Node(root.val);
            if(root.left != null){
                TreeNode children = root.left;
                while(children != null){
                    Node nodeChild = decode(children);
                    node.children.add(nodeChild); 
                    children = children.right;
                }
            }
            return node;   
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
