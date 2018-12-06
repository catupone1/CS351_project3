import java.io.FileNotFoundException;
/**
 * Driver for Creating and heapifying a complete tree of PathNodes.
 * @author Caleb Tupone
 * @author McRae Massey
 *
 */
public class Driver {
	public static void main(String[] args) {
		Heap heap = new Heap();
		try {
			heap.go(args[0]);
		} catch (FileNotFoundException fnf) {
			System.err.println("Error: file not found!");

		}
	}
}