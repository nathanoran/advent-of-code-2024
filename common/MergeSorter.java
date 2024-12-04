package common;

/**
 *  
 * @author Nathan Oran
 *
 */

public class MergeSorter {
    /** 
	 * Constructor accepts an input numbers. 
	 * in the array. 
	 */
	public MergeSorter() {}

    public Integer[] sort(Integer[] values) {
        mergeSort(values);
        return values;
    }

    private void mergeSort(Integer[] pts)
	{
		Integer[] leftSide = new Integer[pts.length / 2]; //creates left side array with first half of elements
		for(int i = 0; i < leftSide.length; i++) {
			leftSide[i] = pts[i];
		}
		Integer[] rightSide = new Integer[pts.length - leftSide.length]; // creates right side away and fills with second half of elements
		for(int i = 0; i < rightSide.length; i++) {
			rightSide[i] = pts[i + leftSide.length];
		}
		
		if(leftSide.length > 1) mergeSort(leftSide); // sorts left side
		if(rightSide.length > 1) mergeSort(rightSide); // sorts right side
		
		int i = 0, j = 0, k = 0;
		while(i < leftSide.length && j < rightSide.length) {
            // while both sides have elements
			if(leftSide[i] - rightSide[j] < 0) {
                // if next Integer in left side is smaller than the right
				pts[k] = leftSide[i];
				i++;
			} else {
                // next Integer in right is smaller or they are the same
                pts[k] = rightSide[j];
				j++;
			}
			k++;
		}

		while(i < leftSide.length) {
            // when the left side still has the bigger Integers it adds them to the end
			pts[k] = leftSide[i]; 
			i++;
			k++;
		}

		while(j < rightSide.length) {
            // when the right side still has the bigger Integers it adds them to the end
			pts[k] = rightSide[j];
			j++;
			k++;
		}
	}
}
