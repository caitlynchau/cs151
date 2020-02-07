public class Arrays{

	public static void swapLargestAndSmallest(int[] a){
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		int smallIndex = -1;
		int largeIndex = -1;

		// find smallest and largest ints
		for (int i = 0; i < a.length; i++){
			if (a[i] < smallest){
				smallest = a[i];
				smallIndex = i;
			}
			if (a[i] > largest){
				largest = a[i];
				largeIndex = i;
			}
		}

		// swap smallest and largest
		int temp = a[smallIndex];
		a[smallIndex] = a[largeIndex];
		a[largeIndex] = temp;
	}
}