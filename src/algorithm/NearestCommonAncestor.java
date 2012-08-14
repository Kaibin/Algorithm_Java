package algorithm;

public class NearestCommonAncestor {

    public static Node findNearestCommonAncestor(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }
        if (a == null || b == null) {
            return null;
        }
        
        if (root == a)
            return a;
        if (root == b)
            return b;
        
        Node llca = findNearestCommonAncestor(root.left, a, b);
        Node rlca = findNearestCommonAncestor(root.right, a, b);
        
        if (llca != null && rlca != null) {
            return root;
        }
        
        if (llca != null){
            return llca;
        }
        return rlca;
            
    }
    
    public static void main(String[] args) {
        Node e = new Node(null,null,"e");
        Node d = new Node(null,null,"d");
        Node c = new Node(e,d,"c");
         
        Node h = new Node(null,null,"h");
        Node g = new Node(null,null,"g");
        Node f = new Node(g,h,"f");
        
        Node root = new Node(c,f,"root");
        
        Node ancestorNode = NearestCommonAncestor.findNearestCommonAncestor(root, g, h);
        
        System.out.println(ancestorNode.name);
    }
}

class Node {
    Node left;
    Node right;
    public String name;
    
    public Node(Node left, Node right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }
    
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.name);
        preOrder(root.left);
        preOrder(root.right);
    }
}
