package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (rightIndex > leftIndex){
			int menor = leftIndex;
			int contador = 0;
			while (contador != rightIndex){
				menor = leftIndex + contador;
				for (int i = leftIndex+contador; i<=rightIndex;i++){
					if (array[i].compareTo(array[menor]) < 0){
						menor = i;
					}
				}
				Util.swap(array,leftIndex+contador, menor);
				contador++;
			}
		}
	}
}
