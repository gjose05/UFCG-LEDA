package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		this.QuickSort(array, 0, array.length-1);
		int contador = 0;
		for (int i = 0; i < array.length; i++){
			if (array[i] < x){
				contador++;
			}
		}
		if (contador == 0){
			return null;
		}
		else{
			return array[contador-1];
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
				int temp = array[i];
				array[i] = array[contador];
				array[contador] = temp;
			}
		}
		int temp = array[contador];
		array[contador] = array[pivot];
		array[pivot] = temp;
		return contador;
	}

}
