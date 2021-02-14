import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class SortsTest {

	@Test
	void MergeSortTest() {
		sorts s = new sorts();
		Comparable[] actual = { 5, 1, 6, 2, 3, 4 };
	    Comparable[] expected = { 1, 2, 3, 4, 5, 6 };
	    s.MergeSort(actual);
	    assertArrayEquals(expected, actual);
	}

	@Test
	void RadixSortTest() {
		/*sorts s = new sorts();
		Comparable[] actual = { 5, 1, 6, 2, 3, 4 };
	    Comparable[] expected = { 1, 2, 3, 4, 5, 6 };
	    s.RadixSort(actual);
	    assertArrayEquals(expected, actual);*/
	}
}
