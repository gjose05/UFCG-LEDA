package sorting.divideAndConquer.hybridMergesort;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			mergeSort(array, leftIndex, meio, rightIndex);
			MERGESORT_APPLICATIONS++;
		}
	}
	private void mergeSort(T[] array, int leftIndex, int meio, int rightIndex) {
		if (array.length <= SIZE_LIMIT) {
			insertionSort(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS++;
		} 			
		else {
			T[] copia = Arrays.copyOf(array, array.length);
			int i = leftIndex;
			int j = leftIndex;
			int k = meio + 1;
			while (i <= meio && k <= rightIndex) {
				if (copia[i].compareTo(copia[k]) < 0) {
					array[j] = copia[i];
					i++;
				} 
				else {
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
	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for(int i = leftIndex+1; i <= rightIndex; i++){
			T p = array[i];
			int j = i-1;		
			int m = i;
			while(j >= 0 && array[j].compareTo(p) > 0){
				array[m] = array[j];
				j--;
				m--;
			}
			array[j+1] = p;
		}
	}
}
