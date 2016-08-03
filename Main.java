import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Main method that runs the sort algorithms on respective arrays. 
 * Sort Methods include: BubbleSort, QuickSort, SelectionSort, MergeSort, and JavaSort.
 * Integer and BigObject arrays are created in either Ascending, Descending, or Random order as specified by user.
 * Tests are run on copies of array and sort times are printed to console.
 * @author Raymond Li
 * @version 05/1/14
 *
 */
public class Main {

	public static void main(String[] args) {
		
		long start, end; // for time testing
		Integer [] dummy = {0, 1, 4, 2, 10, 3}; // dummy array for testing
		Integer size = 0; // size of array = args[0]
		String order; 	// order of array = args[1]
		
		//Error message and exit if less than 2 args provided
		if (args.length < 2) {
			System.err.printf("\nERROR : missing parameters. \n\n");
			System.exit(1);
		}
		
		//Error message and exit if less than 1st arg isn't an int
		try {
			size = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException nonInt) {
			System.err.printf("\nERROR : First argument is not an integer. \n\n");
			System.exit(1);
		}
		
		//Create Integer array with specified size
		Integer[] array = new Integer[size];
		
		//Error message and exit if less than 2 and arg isn't A, D, or R
		order = args[1].toUpperCase();
		if (!order.equals("A") && !order.equals("D") && !order.equals("R")){
			System.err.printf("\nERROR : 2nd argument is not a letter. \n\n");
			System.exit(1);
		}
		
		//create my big object array with specified size
		MyBigObject[] mboArray = new MyBigObject[size];

		//generate two arrays in ascending order
		if (order.equals("A")) {
			for (int i = 0; i<size; i++) {
				Integer integer = new Integer(i);
				array[i] = integer;
				MyBigObject mbo = new MyBigObject(i);
				mboArray[i] = mbo;
			}
		}
		//generate two arrays in descending order
		else if (order.equals("D")){
			for (int i = 0; i<size; i++) {
				Integer integer = new Integer(i);
				array[i] = integer;
				MyBigObject mbo = new MyBigObject(i);
				mboArray[i] = mbo;
			}
			Arrays.sort(array, Collections.reverseOrder());
			Arrays.sort(mboArray, Collections.reverseOrder());
		}
		//generate two arrays in random order
		else if (order.equals("R")) {
			for (int i = 0; i<size; i++) {
				Random rand = new Random();
				Integer integer = new Integer(rand.nextInt());
				array[i] = integer;
				MyBigObject mbo = new MyBigObject();
				mboArray[i] = mbo;
			}
		}
		
		//Holds copy of both types of arrays
		Integer[] bArray = new Integer[size];
		MyBigObject[] bBigObjectArray = new MyBigObject[size];	

		System.out.println("Testing Integer Array:");
		
		//SELECTION SORT
		Sorter.selectionSort(dummy);
		//Copy array
		System.arraycopy(array, 0, bArray, 0, array.length);
		//Start timing
		start = System.nanoTime();
		Sorter.selectionSort(bArray);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading SelectionSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );//MERGESORT
		
		//BUBBLE SORT
		Sorter.bubbleSort(dummy);
		//Copy array
		System.arraycopy(array, 0, bArray, 0, array.length);
		//Start timing
		start = System.nanoTime();
		Sorter.bubbleSort(bArray);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading BubbleSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );

		//MERGE SORT
		Sorter.mergeSort(dummy);
		//Copy array
		System.arraycopy(array, 0, bArray, 0, array.length);
		//Start timing
		start = System.nanoTime();
		Sorter.mergeSort(bArray);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading MergeSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );

		//QUICKSORT
		Sorter.quickSort(dummy, 0, dummy.length-1);
		//Copy array
		System.arraycopy(array, 0, bArray, 0, array.length);
		//Start timing
		start = System.nanoTime();
		Sorter.quickSort(bArray, 0, size-1);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading QuickSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );
		
		//JAVA SORT
		Arrays.sort(dummy);
		//Copy array
		System.arraycopy(array, 0, bArray, 0, array.length);
		//Start timing
		start = System.nanoTime();
		Arrays.sort(bArray);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading JavaSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );
		
		
		//MYBIGOBJECT TESTING STARTS HERE
		System.out.println("\nTesting MyBigObject Array:");
		
		//SELECTIONSORT STARTS HERE
		Sorter.selectionSort(dummy);
		//Copy array
		System.arraycopy(mboArray, 0, bBigObjectArray, 0, size);
		//start timing
		start = System.nanoTime();
		Sorter.selectionSort(bBigObjectArray);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading SelectionSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );
		
		//BUBBLE SORT
		Sorter.bubbleSort(dummy);
		//Copy array
		System.arraycopy(mboArray, 0, bBigObjectArray, 0, size);
		//start timing
		start = System.nanoTime();
		Sorter.bubbleSort(bBigObjectArray);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading BubbleSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );
		
		//MERGESORT
		Sorter.mergeSort(dummy);
		//Copy array
		System.arraycopy(mboArray, 0, bBigObjectArray, 0, size);
		//start timing
		start = System.nanoTime();
		Sorter.mergeSort(bBigObjectArray);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading MergeSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );
		
		//QUICKSORT
		Sorter.quickSort(dummy, 0, dummy.length-1);
		//Copy array
		System.arraycopy(mboArray, 0, bBigObjectArray, 0, size);
		//Start timing
		start = System.nanoTime();
		Sorter.quickSort(bBigObjectArray, 0, size-1);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading QuickSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );
		
		//JAVA Sort
		Arrays.sort(dummy);
		//Copy array
		System.arraycopy(mboArray, 0, bBigObjectArray, 0, size);
		//start timing
		start = System.nanoTime();
		Arrays.sort(bBigObjectArray);
		end = System.nanoTime(); 
		System.out.printf("INFO: Reading JavaSort file took %d ms (~ %7.3f seconds).\n", 
				(end - start)/1000, (end - start)/1000000000.0  );

	}
}
	