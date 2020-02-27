import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tester {

	@Test
	void test1() {
		int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
		int[] b = new int[] { 5, 4, 9, 1, 2, 6 };
		Arrays.swapLargestAndSmallest(a);
		assertArrayEquals(b, a);
		
	}
	
	@Test
	void test2() {
		int[] a = new int[] {1, 4, 1, 9, 2, 6};
		int[] b = new int[] {9, 4, 1, 1, 2, 6};
		Arrays.swapLargestAndSmallest(a);
		assertArrayEquals(b, a);
	}
	
	@Test
	void test3() {
		int[] a = new int[] {1, 4, 2, 9, 9, 6};
		int[] b = new int[] {9, 4, 2, 1, 9, 6};
		Arrays.swapLargestAndSmallest(a);
		assertArrayEquals(b, a);
	}
	
	@Test
	void test4() {
		int[] a = new int[] {1};
		int[] b = new int[] {1};
		Arrays.swapLargestAndSmallest(a);
		assertArrayEquals(b, a);
	}
	
	
}
