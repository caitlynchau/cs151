
public class Sequence implements List {
	private E[] arr;
	private int size;
	
	// constructor
	public Sequence() {
		// initialize arr and size
		this.size = 100;
		arr = new E[size];

		// partially fill the array with elements of type E
	}
	

	public Iterator createIterator() {
		return new Iterator<E>() {
			private int current = 0;
			
			public boolean hasNext() {
				return current < size;	}
			public E next() {
				return arr[current++];	}
			public void remove() {
				throw new UnsupportedOperationException();	}
		};
	}
}
