import java.io.File;

public class Driver {
	public static void main(String[] args){
		// file = new File(args[0]);
		Heap heap = new Heap();
		heap.go(args[0]);
	}
}
