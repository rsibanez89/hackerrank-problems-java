package solutions;

public class IsBinarySearchTree {

	class Node {
		int data;
		Node left;
		Node right;
	}

	private Node getPopulatedTree() {
		Node root = new Node();
		root.data = 3;

		Node left = new Node();
		left.data = 1;

		Node right = new Node();
		right.data = 4;

		Node son = new Node();
		son.data = 5;
		son.left = left;
		son.right = right;

		root.left = son;

		left = new Node();
		left.data = 6;

		son = new Node();
		son.data = 2;
		son.left = left;

		root.right = son;

		return root;
	}

	// Check all the values in the left subtree are smaller than the root
	private boolean checkLeftSubTree(Node root, int rootData) {
		if (root == null)
			return true;
		else {
			if (root.data >= rootData)
				return false;
			boolean left = checkLeftSubTree(root.left, rootData);
			boolean right = checkLeftSubTree(root.right, rootData);
			return left && right;
		}
	}

	// Check all the values in right subtree are bigger than the root
	private boolean checkRightSubTree(Node root, int rootData) {
		if (root == null)
			return true;
		else {
			if (root.data <= rootData)
				return false;
			boolean left = checkRightSubTree(root.left, rootData);
			boolean right = checkRightSubTree(root.right, rootData);
			return left && right;
		}
	}

	private boolean checkBST(Node root) {
		if (root == null)
			return true;
		else {
			// At this point check the values in the subtrees (Not just the first value, all the subtree)
			boolean leftSubtree = checkLeftSubTree(root.left, root.data);
			boolean rightSubtree = checkRightSubTree(root.right, root.data);
			
			// Repeat this process for each of my sons (left, right)
			boolean left = checkBST(root.left);
			boolean right = checkBST(root.right);
			
			return leftSubtree & rightSubtree & left && right;
		}
	}

	public void Run() {
		Node root = getPopulatedTree();
		if (checkBST(root))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static void main(String[] args) {
		new IsBinarySearchTree().Run();
	}

}
