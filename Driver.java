import java.io.FileNotFoundException;

public class Driver {
	public static void main(String[] args) {
		// file = new File(args[0]);
		Heap heap = new Heap();
		try {
			heap.go(args[0]);
		} catch (FileNotFoundException fnf) {
			System.err.println("file not found!");

		}
	}
}