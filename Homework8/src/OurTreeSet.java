
import java.util.TreeSet;

public class OurTreeSet extends TreeSet {
	public TreeNode root;

	// Construct an empty Tree of integers
	public OurTreeSet() {
		root = null;
	}

	// Insert a new node in the binary search tree.
	// If the root node is null, create the root node here.
	// Otherwise, call the insert method of class TreeNode.
		
	public boolean add(Object key) {
        //root =  add(root, key);
        //if (root == null) {
        	//return false;
        //}
        //else return true;
		// Create a new Node and initialize it

				TreeNode newNode = new TreeNode(key);

				// If there is no root this becomes root

				if (root == null) {

					root = newNode;

					return true;
				} else {

					// Set root as the Node we will start
					// with as we traverse the tree

					TreeNode focusNode = root;

					// Future parent for our new Node

					TreeNode parent;

					while (true) {

						// root is the top parent so we start
						// there

						parent = focusNode;

						// Check if the new node should go on
						// the left side of the parent node

						if (((String)key).compareTo(focusNode.data)<0) {

							// Switch focus to the left child

							focusNode = focusNode.left;

							// If the left child has no children

							if (focusNode == null) {

								// then place the new node on the left of it

								parent.left = newNode;
								return true; // All Done

							}

						} else { // If we get here put the node on the right

							focusNode = focusNode.right;

							// If the right child has no children

							if (focusNode == null) {

								// then place the new node on the right of it

								parent.right = newNode;
								return true; // All Done

							}

						}

					}
				}

    }

	
	public void clear() {
		root = null;
	}

	public boolean contains(Object o) {
		return contains(o, root);
	}

	public boolean isEmpty() {
		if (root == null)
			return true;
		else
			return false;
	}
	
	
	public int size() {
		  return size(root);
	}
	
	private int size(TreeNode node) {
		if ( node == null )
	         return 0;
	      int cnt=1;
	      cnt=cnt+size( node.left );
	      cnt=cnt+size( node.right );

	      return cnt;
	}

	private boolean contains(Object o, TreeNode node) {
		if (node == null)
			return false;

		int cmp = ((String) o).compareTo(node.data);
		if (cmp < 0)
			return contains(o, node.left);
		else if (cmp > 0)
			return contains(o, node.right);
		else
			return true;
	}

	public void display(TreeNode node) {
		if (node == null)
			return;
		display(node.left);
		System.out.print(node.data + ", ");
		display(node.right);
	}
}
