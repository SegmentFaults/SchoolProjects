/**
 * A binary tree implementation. Most of the logic of this tree can be found in
 * the Node class. This class just calls most of those methods by using the root
 * of this tree.
 * 
 * @author Norm Krumpe
 *
 */

public class BinaryTree {
	public Node root;

	public BinaryTree() {
		root = null;
	}

	/**
	 * Returns the height of this tree
	 * 
	 * @return
	 */
	public int getHeight() {
		if (root == null) {
			return 0;
		}
		else{
			return root.getHeight();
		}
		
	}

	public int getNumberOfNodes() {
		int num=0;
		if (root!=null){
			num++;
		}
		if (root!=null && root.left!=null){
			num=num+root.left.getNumberOfNodes();
		}
		if (root!=null && root.right!=null){
			num=num+root.right.getNumberOfNodes();
		}
		return num;
	}

	public int getNumberOfLeaves() {
		if(root==null){
			return 0;
		}
		else{
			return root.getNumberOfLeaves();
		}
	}

	/**
	 * Prints the preorder traversal of this tree
	 */
	public void preorderTraversal() {
		if(root!=null){
			root.preorderTraversal();
		}
	}

	/**
	 * Prints the inorder traversal of this tree
	 */
	public void inorderTraversal() {
		if (root != null) {
			root.inorderTraversal();
		}

	}

	/**
	 * Prints the postorder traversal of this tree
	 */
	public void postorderTraversal() {
		if(root!=null){
			root.postorderTraversal();
		}
	}

	public boolean isFull() {
		if (root==null){
			return true;
		}
		else{
			return root.isFull();
		}
	}

	public boolean isLeaf() {
		if (root!=null){
			return root.isLeaf();
		}
		else{
			return false;
		}
	}

	public boolean contains(int value) {
		if (root != null) {
			return root.contains(value);

		}
		return false;
	}
}
