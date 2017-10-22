/**
 * A binary search tree. That is, all values in the left subtree of a given node
 * must be less than the value at that node, and all values in the right subtree
 * of a given node must be greater than the value at that node. Note that the
 * tree will not contain duplicates. If one attempts to add a value that is
 * already in the tree, that add will be ignored.
 * 
 * @author Norm Krumpe
 *
 */
public class BinarySearchTree extends BinaryTree {

	/**
	 * Adds the specified value to the appropriate location in this binary
	 * search tree.
	 * 
	 * @param value
	 *            the value to be added to the tree.
	 */
	public void add(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			add(value, root);
		}
	}

	/**
	 * Recursive add method, finding the appropriate empty location where the
	 * value can be added.
	 * 
	 * @param value
	 *            the value to be added to the tree
	 * @param n
	 *            the root of the subtree to which the value should be added
	 */
	private void add(int value, Node n) {
		assert n != null;
		if (value < n.data) {
			if (n.left == null) {
				n.left = new Node(value);
			}
			add(value, n.left);
		} else if (value > n.data) {
			if (n.right == null) {
				n.right = new Node(value);
			}
			add(value, n.right);
		}
		//else is a duplicate and do nothing.
	}

	/**
	 * Because this is a binary search tree and not just a binary tree, let's
	 * use a binary search.
	 * 
	 * @value value the sought after value
	 * @return true if the value is in this binary search tree, and false
	 *         otherwise
	 */
	@Override
	public boolean contains(int value) {
	    if (root==null){
	    	return false;
	    }
	    if(root.data  == value){
	    	return true;
	    }
	    else if( root.left != null && value<root.data && root.left.contains(value)){
	    	return true;
	    }
	    else if( root.right!=null && root.data<value && root.right.contains(value)) {
	    	return true;
	    }
	    // no matching node was found
	    return false;
	}

	/**
	 * Recursive search through the binary search tree to find the specified
	 * value.
	 * 
	 * @param value
	 *            the sought after value
	 * @param n
	 *            the root of the subtree in which the value will be sought
	 * @return true if the value is found, and false otherwise
	 */
	private boolean binarySearch(int value, Node n) {
		return contains(value);
	}

}
