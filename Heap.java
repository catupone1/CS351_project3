import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 
 * @author Caleb Tupone
 * @author McRae Massey
 */

public class Heap {
	/** Temporary storage for the paths starting at tempPath[1]. */
	private ArrayList<PathNode> tempPath;
	
	public void go(String args){
		readPaths(args);
	}

/**
* Reads inputFile given at the command line and places the contents of each line into the
* path field found in each PathNode object. The order is the same as found in the text file.
* Adds the PathNode object to tempPath starting at tempPath[1].
*
* @param inputFile Name of the input file to be read.
 * @return 
* @throws FileNotFoundException if the input file cannot be found.
*/
	void readPaths(String inputFile){
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		ArrayList<String> line = new ArrayList<String>();
		try{
			Scanner scan = new Scanner(new File(inputFile));
			while(scan.hasNext()){
				line.add(scan.nextLine());
				
			}
			System.out.println(line.toString());
			//System.out.println(data.toString());
			for(int i = 0;i<line.size();i++){
				String[] s = line.get(i).split("%s");
				//Integer.parseInt();
			}

			scan.close();
		}catch(FileNotFoundException fnf){
			System.err.println("file not found!");
			fnf.printStackTrace();
		}
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
		return null;

	}

	/**
	 * Recursive method that sets isLevelEnd.
	 * 
	 * @param root
	 *            Root of the subtree.
	 * @return
	 */
	void setLevelEnd(PathNode root) {

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

	}
}
