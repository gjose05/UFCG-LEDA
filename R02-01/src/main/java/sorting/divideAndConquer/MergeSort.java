package sorting.divideAndConquer;

import java.util.Arrays;

import sorting.AbstractSorting;
/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;

			this.sort(array, leftIndex, meio);
			this.sort(array, meio + 1, rightIndex);

			mergeSort(array, leftIndex, meio, rightIndex);
		}
	}

	private void mergeSort(T[] array, int leftIndex, int meio, int rightIndex) {
		T[] copia = Arrays.copyOf(array, array.length);
		int i = leftIndex;
		int j = leftIndex;
		int k = meio + 1;

		while (i <= meio && k <= rightIndex) {
			if (copia[i].compareTo(copia[k]) < 0) {
				array[j] = copia[i];
				i++;
			} else {
				array[j] = copia[k];
				k++;
			}
			j++;
		}
		while (k <= meio) {
			array[j] = copia[k];
			j++;
			k++;
		}
		while (i <= meio) {
			array[j] = copia[i];
			i++;
			j++;
		}
	}
}
