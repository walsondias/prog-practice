public class Node{
	public Node left, right;
}

public class BinaryTree{
	Node root;
	
	/*Get the height of a tree*/
	public int getHeight(){return getHeight(root);}
	public int getHeight(Node node){
		if(node == null)
			return 0;
		return 1 + Math.max(hetHeight(node.left), getHeight(node.right));
	}
	
	
}
