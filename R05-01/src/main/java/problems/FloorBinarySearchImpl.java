package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if (array == null || array.length == 0){
			return null;
		}
		this.QuickSort(array, 0, array.length-1);
		if (x <= array[0]){
			return null;
		}
		if ( x>= array[array.length-1]){
			return array[array.length-1];
		}
		return array[BuscaBinaria(array, 0, array.length-1, x)];
	}

	private Integer BuscaBinaria(Integer[] array,int left, int right, int x){
		if (left==right){
			return left-1;
		}
		int meio = (left+right)/2;
		if (array[meio] == x || array[meio] == array[0]){
			return meio;
		}
		else if (x>array[meio]){
			return BuscaBinaria(array,meio+1,array.length-1,x);
		}
		else{
			return BuscaBinaria(array, 0, meio,x);
		}
	}
	private Integer[] QuickSort(Integer[] array, int left, int right){
		if (right > left){
			int pivot = partition(array,left,right);
			QuickSort(array,left,pivot-1);
			QuickSort(array,pivot+1,right);
		}
		return array;
	}
	private int partition(Integer[] array, int left, int right){
		int pivot = left;
		int contador = left;
		for (int i = left+1; i <= right; i++){
			if (array[pivot] > array[i]){
				contador++;
				Util.swap(array, contador, i);
			}
		}
		Util.swap(array, pivot, contador);
		return contador;
	}

}
