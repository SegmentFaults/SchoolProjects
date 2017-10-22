/**
 * A node class to support a binary tree.  We can put most methods into this class
 * and then call them from the BinaryTree class.
 * @author Norm Krumpe
 *
 */

class Node {
	int data;
	Node left, right;

	// Wraps an int with a node
	Node(int data) {
		this.data = data;
		left = right = null;
	}

	/**
	 * Gets the height of the tree with this node as its root. A tree with one
	 * node has a height of 1. Note that since this node exists, the height will
	 * be 1 (for this node) plus the height of its tallest subtree (if a subtree
	 * is null, that subtree's height is zero).
	 * @return the height of the tree rooted at this node
	 */
	int getHeight() {
		int leftHeight = 0, rightHeight = 0;

		if (left != null) {
			leftHeight = left.getHeight();
		}
		if (right != null) {
			rightHeight = right.getHeight();
		}

		return 1 + Math.max(leftHeight, rightHeight);
	}

	/**
	 * Gets the number of nodes with this tree as its root. A tree with one node
	 * has a node count of 1. Note that since this node exists, the count will
	 * be 1 (for this node) plus the count for each of its subtrees.
	 */
	int getNumberOfNodes() {
		int result=0;
		if (this.right!=null){
			result=result+right.getNumberOfNodes();
		}
		if (this.left!=null){
			result=result+left.getNumberOfNodes();
		}
		return 1+result;
		
	}
	
	/**
	 * Returns true if this or one of its subtrees contains value,
	 * and false otherwise.
	 * @param value
	 * @return
	 */
	public boolean contains(int value) {
		if(this.data==value){
			return true;
		}
		if(this.left!=null && this.left.contains(value)){
			return true;
		}
		if (this.right!=null && this.right.contains(value)){
			return true;
		}
		return false;
		
		
	}
	
	/**
	 * Prints the preorder traversal of this tree, printing
	 * the value at this node, followed by all the values in the left
	 * subtree, followed by all the values in the right subtree.
	 */
	void preorderTraversal() {
		//root left right
		System.out.println(data +" ");
		if (left!=null)
			left.preorderTraversal();
		if (right!=null)
			right.preorderTraversal();
		
	}
	
	/**
	 * Prints the inorder traversal of this tree, printing
	 * the value at this node, followed by all the values in the left
	 * subtree, followed by all the values in the right subtree.
	 */
	void inorderTraversal() {		
		if (left != null)
			left.inorderTraversal();
		System.out.print(data + " ");
		if (right != null)
			right.inorderTraversal();
	}
	
	/**
	 * Prints the postorder traversal of this tree, printing
	 * the value at this node, followed by all the values in the left
	 * subtree, followed by all the values in the right subtree.
	 */
	void postorderTraversal() {		
		//left right root
		if (left!=null)
			left.postorderTraversal();
		if (right!=null)
			right.postorderTraversal();
		System.out.println(data+" ");
	}
	
	/**
	 * Returns true if this leaf is a node, and false otherwise.
	 */
	boolean isLeaf() {
		return (left == null && right == null);
	}
	
	/**
	 * Gets the number of leaves with this tree as its root.
	 */
	int getNumberOfLeaves() {
		int num=0;
		if (left!=null){
			num=num+left.getNumberOfLeaves();
		}
		if (right!=null){
			num=num+right.getNumberOfLeaves();
		}
		if (this.isLeaf()){
			num++;
		}
		return num;
	}
	
	/**
	 * Returns whether a binary tree is full.  In a tree with 
	 * height h, if all the nodes in level h are leaves, and
	 * all other nodes have exactly two children, then the tree
	 * is full.
	 */
	boolean isFull() {
	        // if leaf node
	        if(left == null && right == null )
	            return true;
	          
	        // if both left and right subtrees are not null
	        // the are full
	        if((left!=null) && (right!=null))
	            return (left.isFull() && right.isFull());
	          
	        // if none work
	        return false;	
	}
	
}
