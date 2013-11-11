public class Node{
	public Node left, right;
	public int value;
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
	
	/*Given a binary tree, test whether it is a BST (Binary Search Tree)*/
	public boolean isBST(){	return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);}
	public boolean isBST(Node node, int minVal, int maxVal){
		if(node == null)
			return true;
		return node.value>minVal 
			&& node.val<=maxVal 
			&& isBST(node.left,minVal, node.value) 
			&& isBST(node.right, node.value, maxVal);
	}
	
	/*Given two random nodes in a tree, not necessarily a BST, find their common parent*/
	public Node getCommonParent(Node n1, Node n2){
		ArrayList <Node> lst1 = new ArrayList <Node>();
		ArrayList <Node> lst2 = new ArrayList <Node>();
		explore(root, n1, lst1);
		explore(root, n2, lst2);
		int i=0;
		while(lst1.get(i).equals(lst2.get(i)))
			i++;
		return lst1.get(i-1);
	}
	public boolean explore(Node n, Node nx, lst){
		if(n == null)
			return false;
		lst.add(n);
		if(n == nx)
			return true;
		if(explore(n.left, nx, lst) || explore(n.right, nx, lst))
			return true;
		lst.remove(n);
		return false;
	}
}
