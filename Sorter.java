import java.lang.reflect.Array;

/**
 * Constructor class that contains all sort methods.
 * Sort Methods include: BubbleSort, QuickSort, SelectionSort, MergeSort, and JavaSort.
 * @author Raymond Li
 * @version 5/1/14
 */
public class Sorter {
	//Private Constructor
	private Sorter() {
		
	}

    //MERGESORT 
    
/**
 * Runs mergeSort
 * @param temp
 * 		Array to be sorted
 */
    public static <T extends Comparable> void mergeSort(T[] temp) {
        if (temp.length > 1) {
            // split array into two halves
            T[] left = leftHalf(temp);
            T[] right = rightHalf(temp);
            
            // recursively run mergeSort on both sides
            mergeSort(left);
            mergeSort(right);
            
            // merge the two sorted halves
            merge(temp, left, right);
        }
    }
    
    /**
     * Returns left half of the array
     * @param temp
     * 		Given array to be sorted
     * @return
     * 		Returns left half of the array
     */
    public static <T extends Comparable> T[] leftHalf(T[] temp) {
    	//find the # of elements in the left half
        int sizeLeft = temp.length / 2;
        //create generic array holding sizeLeft elements
        T[] left = (T[]) Array.newInstance(temp.getClass().getComponentType(), sizeLeft);
        //copy over the elements from the original array into the left half array
        for (int i = 0; i < sizeLeft; i++) {
            left[i] = temp[i];
        }
        //return the left half array
        return left;
    }
    
    /**
     * Returns right half of the array to be sorted
     * @param temp
     * 		Array to be sorted
     * @return
     * 		Returns the right half of the array to be sorted
     */
    public static <T extends Comparable> T[] rightHalf(T[] temp) {
    	//find the # of elements in the right half
        int sizeLeft = temp.length / 2;
        int sizeRight = temp.length - sizeLeft;
        //create generic array holding sizeLeft elements
        T[] right = (T[]) Array.newInstance(temp.getClass().getComponentType(), sizeRight);
      //copy over the elements from the original array into the right half array
        for (int i = 0; i < sizeRight; i++) {
            right[i] = temp[i + sizeLeft];
        }
        //return the right half array
        return right;
    }
    
    /**
     * Merge method to combine the sorted left and right subarrays 
     * @param temp
     * 		Array that holds final array
     * @param leftSub
     * 		Sorted left array
     * @param rightSub
     * 		Sorted right array
     */
    public static <T extends Comparable> void merge(T[] temp, 
                             T[] leftSub, T[] rightSub) {
    	//Start from the left most index/position from each subarray
        int leftPos = 0;
        int rightPos = 0;
        
        //loop through both subarrays
        for (int i = 0; i < temp.length; i++) {
        	// if both subarrays haven't been traversed and the
        	//element in the left subarray is less than the element in the 
        	//right subarray
            if (rightPos >= rightSub.length || (leftPos < leftSub.length && 
                    (leftSub[leftPos].compareTo(rightSub[rightPos])) <= 0)) {
            	//place the left subarray element into the larger temp array
                temp[i] = leftSub[leftPos];   
                leftPos++;
                //else place the right subarray element in the larger temp array
            } else {
                temp[i] = rightSub[rightPos];  
                rightPos++;
            }
        }
    }
    
    //SELECTION SORT
    /**
     * Sorts an array via selection sort method
     * @param array
     * 		array given to be sorted
     */
    static <T extends Comparable>void selectionSort(T[] array) {
    	 //Stores the index of the biggest number in the array
    		int biggest = 0;
    	 //Select the biggest number and traverse array
    	  for (int i=0; i<array.length-1; i++) {
    	    //traverse and find the biggest value in the array by comparing each element to biggest
    	    for (int j=1; j<array.length-i; j++) // 
    	      // If you find a bigger value, store the index position and swap
    	      if (array[j].compareTo(array[biggest]) > 0)
    	        biggest = j; 
    	    swap(array, biggest, array.length-i-1); 
    	  }
    	}
    /**
     * Sorts array via bubble sort
     * @param array
     * 		Given array to be sorted
     */
    public static <T extends Comparable> void bubbleSort(T array[]) {
    	//stores the index of the next element being compared to
        int nextIndex;
        //For loop places the biggest element at the end of the array
        //Prevents unnecessary iterations
        for (int m = array.length; m >= 0; m--) {
        	//loop from the front and compare each element to the nextIndex element
            for (int i = 0; i < array.length - 1; i++) {
            	//nextIndex is one after the element being compared
                nextIndex = i + 1;
            	//swap if nextIndex element being compared to is smaller and repeat until end
                if (array[i].compareTo(array[nextIndex]) > 0) {
                    swap(array, i, nextIndex);
                }
            }
        }
    }
/**
 * Swaps two elements in an array
 * @param intArray
 * 		Array where swap occurs
 * @param a
 * 		Index of first element being swapped
 * @param b
 * 		Index of second element being swapped
 */
	  private static <T extends Comparable> void swap(T[] intArray, int a, int b) {
		    T temp = intArray[a];
		    intArray[a] = intArray[b];
		    intArray[b] = temp;
		    }
	  
	  //QUICKSORT
	  /**
	   * Quicksort method works by finding pivot points, partitioning, and sorting
	   * @param array
	   * 	Array to be sorted
	   * @param startIndex
	   * 	First element index in the array
	   * @param endIndex
	   * 	Last element index in the array
	   */
	  public static <T extends Comparable> void quickSort(T[] array, int startIndex, int endIndex) { 
		  //find the pivot in the middle of the array
		  int pivotIndex = findPivot(array, startIndex, endIndex); 
		  //swap pivots and push pivot to the end of the array
		  swap(array, pivotIndex, endIndex); 
		  // Partition the array and store the first position in the right subarray
		  int partIndex = partition(array, startIndex, endIndex-1, array[endIndex]);
		  //Swap back the pivot 
		  swap(array, partIndex, endIndex);
		  //recurisvely sort left array
		  if ((partIndex-startIndex) > 1) quickSort(array, startIndex, partIndex-1); 
		  //recursively sort right array
		  if ((endIndex-partIndex) > 1) quickSort(array, partIndex+1, endIndex); 
		}
	  /**
	   * Returns the index of the pivot point
	   * @param array
	   * 	The (sub)array in which pivot point is being looked for
	   * @param startIndex
	   * 	Start Index position of array
	   * @param endIndex
	   * 	Ending index position of array
	   * @return
	   * 	Return index of the pivot point
	   */
	  public static <T extends Comparable>int findPivot(T[] array, int startIndex, int endIndex){
		  return (startIndex+endIndex)/2; 
		  }
	  /**
	   * Method to partition the array
	   * @param array
	   * 	Array being sorted
	   * @param leftBound
	   * 	Left bound of the (sub)array. Move right until element selected is less than pivot point
	   * @param rightBound
	   * 	Right bound of the (sub)array. Moves left until element selected is greater than pivot point or passes left bound
	   * @param pivot
	   * 	Pivot point that elements are being compared to
	   * @return
	   * 	Returns the first position in the right partition
	   */
	  public static <T extends Comparable>int partition(T[] array, int leftBound, int rightBound, T pivot) {
		  //Make sure left bound is to the left of the right bound
		  while (leftBound <= rightBound) { 
			  //while the left bound is less than the pivot point, traverse rightwards
			  while (array[leftBound].compareTo(pivot) < 0) {
				  leftBound++;
				  }
			  //while the right bound is greater than the pivot point and it hasn't crossed the left bound, traverse leftwards
			  while ((rightBound >= leftBound) && (array[rightBound].compareTo(pivot) >= 0)) {
				  rightBound--;
				  }
			  //Swap values if the right bound is greater than the left bound after they've crossed each other
			  if (rightBound > leftBound) {
				  swap(array, leftBound, rightBound); 
				  }
			  }
		  return leftBound;        
		  }
}
