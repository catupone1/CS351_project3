import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Caleb Tupone
 * @author McRae Massey
 */

public class Heap {
	/** Temporary storage for the paths starting at tempPath[1]. */
	private ArrayList<PathNode> tempPath = new ArrayList<PathNode>();

	boolean flag = true;

	int counter = 0;

	boolean heapified = false;

	public void go(String args) throws FileNotFoundException {
		PathNode iAmRoot = new PathNode();
		readPaths(args);
		iAmRoot = buildCompleteTree(1, 0);
		// System.out.println(tempPath);
		setLevelEnd(iAmRoot);

		setGenerationLinks(iAmRoot);

		// After heapify
		//heapified = true;
		printTreeLevels(iAmRoot);
	}

	/**
	 * Reads inputFile given at the command line and places the contents of each
	 * line into the path field found in each PathNode object. The order is the
	 * same as found in the text file. Adds the PathNode object to tempPath
	 * starting at tempPath[1].
	 *
	 * @param inputFile
	 *            Name of the input file to be read.
	 * @return
	 * @throws FileNotFoundException
	 *             if the input file cannot be found.
	 */
	private void readPaths(String inputFile) throws FileNotFoundException {
		tempPath.add(null);

		ArrayList<String> line = new ArrayList<String>();

		Scanner scan = new Scanner(new File(inputFile));
		while (scan.hasNext()) {
			line.add(scan.nextLine());

		}

		for (int i = 0; i < line.size(); i++) {
			ArrayList<Integer> data = new ArrayList<Integer>();
			String[] path = line.get(i).split(" ");

			for (String a : path) {

				data.add(Integer.parseInt(a));
			}

			PathNode node = new PathNode(data);

			tempPath.add(node);

		}

		scan.close();
	}

	/**
	 * Recursively builds a complete binary tree. Places PathNode objects in
	 * tempPath into a complete binary tree in order of appearance in the text
	 * file. The left child of a parent located at tempPath[index] is found at
	 * tempPath[2 * index] and the right child is found at tempPath[(2 * index)
	 * + 1].
	 *
	 * @param index
	 *            Index of the current node in tempPath.
	 * @param parent
	 *            Parent of the current node.
	 * @return A reference to the node just placed in the tree.
	 */
	PathNode buildCompleteTree(int index, int parent) {
		// only insert if in list
		if (index > tempPath.size() - 1) {
			return null;
		}
		// node to insert
		PathNode localRoot = tempPath.get(index);
		// parent
		localRoot.setParent(tempPath.get(parent));
		// left child
		localRoot.setLeft(buildCompleteTree(2 * index, index));
		// right child
		localRoot.setRight(buildCompleteTree(2 * index + 1, index));

		return localRoot;
	}

	/**
	 * Recursive method that sets isLevelEnd.
	 * 
	 * @param root
	 *            Root of the subtree.
	 * @return
	 */
	void setLevelEnd(PathNode root) {
		root.setLevelEnd(true);

		if ((root.getLeft() != null)) {

			setLevelEnd(root.getLeft());
		}

	}

	/**
	 * Recursive method that sets the "generation" link of PathNode objects from
	 * left-to-right. generation is a term I use to indicate nodes on the same
	 * level (these may be siblings or cousins)
	 * 
	 * @param root
	 *            Root of the subtree.
	 * @return
	 */
	void setGenerationLinks(PathNode root) {
		PathNode tmp = new PathNode();

		if (root.getRight() != null) {
			root.getLeft().setGeneration(root.getRight());

		}

		tmp = root;
		while (tmp.getGeneration() != null) {

			tmp = tmp.getGeneration();

			if (tmp.getGeneration() == null) {
				if (tmp.getParent().getGeneration() != null) {
					tmp.setGeneration(tmp.getParent().getGeneration().getLeft());
				} else if (tmp.getParent().getRight() != null && tmp.getParent().getRight() != tmp) {
					tmp.setGeneration(tmp.getParent().getRight());
				}
			}

		}
		if (root.getLeft() != null)
			setGenerationLinks(root.getLeft());

	

	}

	/**
	 * Prints the path lengths from left-to-right at each level in the tree in
	 * the form specified by the instructions.
	 * 
	 * @param root
	 *            Root of the whole tree to begin printing from.
	 * @return
	 */
	void printTreeLevels(PathNode root) {
		if (flag == true) {
			if (heapified == false) {
				System.out.println("---------- Before Heapify ----------");
				flag = false;
			} else {
				System.out.println("---------- After Heapify ----------");
				flag = false;
			}

		}

		if (counter == 0) {
			System.out.print("Root:    " + (root.getPath().size() - 1) + root);
		} else {
			PathNode tmp = new PathNode();
			tmp = root;
			System.out.print("Level " + counter + ": ");
			System.out.print("" + (tmp.getPath().size() - 1) + tmp + "--> ");
			while (tmp.getGeneration() != null) {
				tmp = tmp.getGeneration();
				System.out.print("" + (tmp.getPath().size() - 1) + tmp);
				if (tmp.getGeneration() != null)
					System.out.print("--> ");
			}

		}
		counter++;
		System.out.println("");
		if (root.getLeft() != null)
			printTreeLevels(root.getLeft());

	}
}
