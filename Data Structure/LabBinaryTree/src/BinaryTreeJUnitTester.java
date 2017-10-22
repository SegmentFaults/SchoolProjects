import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeJUnitTester {

	@Test
	public void testContainsBinaryTree() {
		BinaryTree tree = new BinaryTree();
		assertFalse(tree.contains(20));

		tree.root = new Node(20);
		assertTrue(tree.contains(20));
		assertFalse(tree.contains(25));

		tree.root.left = new Node(40);
		assertTrue(tree.contains(20));
		assertTrue(tree.contains(40));
		assertFalse(tree.contains(25));

		tree.root.right = new Node(10);
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(20));
		assertTrue(tree.contains(40));
		assertFalse(tree.contains(25));

		tree.root.right.right = new Node(0);
		assertTrue(tree.contains(0));
		assertTrue(tree.contains(10));
		assertTrue(tree.contains(20));
		assertTrue(tree.contains(40));
		assertFalse(tree.contains(25));
	}

	// Checks whether nodes are getting added to the correct location in
	// the BST
	@Test
	public void testAddBST() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(3);

		assertEquals(3, bst.root.data);

		bst.add(10);
		assertEquals(3, bst.root.data);
		assertEquals(10, bst.root.right.data);

		bst.add(100);
		assertEquals(3, bst.root.data);
		assertEquals(10, bst.root.right.data);
		assertEquals(100, bst.root.right.right.data);

		bst.add(2);
		assertEquals(3, bst.root.data);
		assertEquals(2, bst.root.left.data);
		assertEquals(10, bst.root.right.data);
		assertEquals(100, bst.root.right.right.data);

		bst.add(1);
		assertEquals(3, bst.root.data);
		assertEquals(2, bst.root.left.data);
		assertEquals(1, bst.root.left.left.data);
		assertEquals(10, bst.root.right.data);
		assertEquals(100, bst.root.right.right.data);

		bst.add(3);
		assertEquals(3, bst.root.data);
		assertEquals(2, bst.root.left.data);
		assertEquals(1, bst.root.left.left.data);
		assertEquals(10, bst.root.right.data);
		assertEquals(100, bst.root.right.right.data);

		assertEquals(5, bst.getNumberOfNodes());

	}

	@Test
	public void testContainsBST() {
		BinarySearchTree bst = new BinarySearchTree();
		assertFalse(bst.contains(5));

		// A bunch of even numbers
		int[] data = { 18, 8, 4, 16, 10, 14, 12, 30, 24, 6, 22 };

		for (int d : data) {
			bst.add(d);
		}

		for (int d : data) {
			assertTrue(bst.contains(d));
			assertFalse(bst.contains(d + 1)); // odd
			assertFalse(bst.contains(d - 1)); // odd
		}

	}

	@Test
	public void testGetHeight() {
		BinaryTree tree = new BinaryTree();
		assertEquals(0, tree.getHeight());

		tree.root = new Node(20);
		assertEquals(1, tree.getHeight());

		tree.root.left = new Node(40);
		assertEquals(2, tree.getHeight());

		tree.root.right = new Node(10);
		assertEquals(2, tree.getHeight());

		tree.root.right.right = new Node(0);
		assertEquals(3, tree.getHeight());
	}

	@Test
	public void testGetNumberOfNodes() {
		BinaryTree tree = new BinaryTree();
		assertEquals(0, tree.getNumberOfNodes());

		tree.root = new Node(20);
		assertEquals(1, tree.getNumberOfNodes());

		tree.root.left = new Node(40);
		assertEquals(2, tree.getNumberOfNodes());

		tree.root.right = new Node(10);
		assertEquals(3, tree.getNumberOfNodes());

		tree.root.right.right = new Node(0);
		assertEquals(4, tree.getNumberOfNodes());
	}

	@Test
	public void testGetNumberOfLeaves() {
		BinaryTree tree = new BinaryTree();
		assertEquals(0, tree.getNumberOfLeaves());

		tree.root = new Node(20);
		assertEquals(1, tree.getNumberOfLeaves());

		tree.root.left = new Node(40);
		assertEquals(1, tree.getNumberOfLeaves());

		tree.root.right = new Node(10);
		assertEquals(2, tree.getNumberOfLeaves());

		tree.root.right.right = new Node(0);
		assertEquals(2, tree.getNumberOfLeaves());
	}

	@Test
	public void testIsFull() {
		BinaryTree tree = new BinaryTree();
		assertTrue(tree.isFull());

		tree.root = new Node(20);
		assertTrue(tree.isFull());

		tree.root.left = new Node(40);
		assertFalse(tree.isFull());

		tree.root.right = new Node(10);
		assertTrue(tree.isFull());

		tree.root.right.right = new Node(0);
		assertFalse(tree.isFull());
	}

	@Test
	public void testIsLeaf() {
		BinaryTree tree = new BinaryTree();
		assertFalse(tree.isLeaf());

		tree.root = new Node(20);
		assertTrue(tree.isLeaf());

		tree.root.left = new Node(40);
		assertFalse(tree.isLeaf());
		assertTrue(tree.root.left.isLeaf());

		tree.root.right = new Node(10);
		assertFalse(tree.isLeaf());
		assertTrue(tree.root.left.isLeaf());
		assertTrue(tree.root.right.isLeaf());

		tree.root.right.right = new Node(0);
		assertFalse(tree.isLeaf());
		assertTrue(tree.root.left.isLeaf());
		assertFalse(tree.root.right.isLeaf());
		assertTrue(tree.root.right.right.isLeaf());

		tree.root.left.left = new Node(5);
		assertFalse(tree.isLeaf());
		assertFalse(tree.root.left.isLeaf());
		assertTrue(tree.root.left.left.isLeaf());
		assertFalse(tree.root.right.isLeaf());
		assertTrue(tree.root.right.right.isLeaf());
	}

}
