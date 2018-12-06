import java.util.ArrayList;

/**
 * Creates a node object to be used in a complete binary tree.
 * @author Caleb Tupone
 * @author McRae Massey
 *
 */

public class PathNode{

	/** An ArrayList of vertex IDs ordered by appearance in the path. */
	private ArrayList<Integer> path;
	/** Reference to the left child. */
	private PathNode left;
	/** Reference to the right child. */
	private PathNode right;
	/** Reference to the parent. */
	private PathNode parent;
	/** Reference to the node directly to the right on the same tree level. */
	private PathNode generation; // left to right sibling or cousin
	/** True if the node is last in the level going from right to left. */
	private boolean isLevelEnd;
	/** True if the node is the right-most node in the last level. */
	private boolean isLastNode;

	public PathNode() {

	}

	/**
	 * 
	 * @param path
	 */
	public PathNode(ArrayList<Integer> path) {
		this.path = path;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.generation = null;
		isLevelEnd = false;
		isLastNode = false;
	}

	/**
	 * Returns the path that is assigned to this node
	 * 
	 * @return the path stored within the path node
	 */
	public ArrayList<Integer> getPath() {
		return path;
	}

	/**
	 * Sets the path that is stored is this path node
	 * 
	 * @param path
	 *            the path that will be stored
	 */
	public void setPath(ArrayList<Integer> path) {
		this.path = path;
	}

	/**
	 * Returns the left child of this path node
	 * 
	 * @return a reference to the left child of the current node
	 */
	public PathNode getLeft() {
		return left;
	}

	/**
	 * Sets the left child of the current path node to the parameter
	 * 
	 * @param left
	 *            the node that will be assigned as the left child
	 */
	public void setLeft(PathNode left) {
		this.left = left;
	}

	/**
	 * Returns the right child of this path node
	 * 
	 * @return a reference to the right child of the current node
	 */
	public PathNode getRight() {
		return right;
	}

	/**
	 * Sets the right child of the current path node to the parameter
	 * 
	 * @param right
	 *            the node that will be assigned as the right child
	 */
	public void setRight(PathNode right) {
		this.right = right;
	}

	/**
	 * Returns the parent of this path node
	 * 
	 * @return a reference to the parent of the current node
	 */
	public PathNode getParent() {
		return parent;
	}

	/**
	 * Sets the parent of the current path node to the parameter
	 * 
	 * @param parent
	 *            the node that will be assigned as the parent
	 */
	public void setParent(PathNode parent) {
		this.parent = parent;
	}

	/**
	 * Returns the node to the right of this path node
	 * 
	 * @return a reference to the node to the right
	 */
	public PathNode getGeneration() {
		return generation;
	}

	/**
	 * Sets the node to the right of the current path node to the parameter
	 * 
	 * @param generation
	 *            the node that will be assigned to the right
	 */
	public void setGeneration(PathNode generation) {
		this.generation = generation;
	}

	/**
	 * Returns t/f if the current path node is the leftmost node in it's level
	 * 
	 * @return t/f if the path node is the the leftmost node in it's level
	 */
	public boolean isLevelEnd() {
		return isLevelEnd;
	}

	/**
	 * Sets the current path node to be labeled as the leftmost node in it's
	 * level
	 * 
	 * @param isLevelEnd
	 *            t/f that sets this path node to be the level end
	 */
	public void setLevelEnd(boolean isLevelEnd) {
		this.isLevelEnd = isLevelEnd;
	}

	/**
	 * Returns t/f if the current path node is the last node in the tree
	 * 
	 * @return t/f if the path node is the last node in the tree
	 */
	public boolean isLastNode() {
		return isLastNode;
	}

	/**
	 * sets the current path node to be labeled as the last node in the tree
	 * 
	 * @param isLastNode
	 *            t/f that sets this path node to be the last node
	 */
	public void setLastNode(boolean isLastNode) {
		this.isLastNode = isLastNode;
	}

	@Override
	public String toString() {
		return this.getPath() + "";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PathNode other = (PathNode) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

}