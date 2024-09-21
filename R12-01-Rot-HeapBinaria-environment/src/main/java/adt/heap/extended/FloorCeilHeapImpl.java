package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		if (array.length != 0 && array != null){
			HeapImpl<Integer> heap = new HeapImpl<>(comparator);
			for(int i = 0; i < array.length;i++){
				heap.insert(array[i]);
			}
			return floorRecursivo(heap,heap.rootElement(),numero);
			}
		return null;
	}
	private Integer floorRecursivo(HeapImpl<Integer> heap,Integer numeroProximo, double numero){
		heap.extractRootElement();
		if (!heap.isEmpty()){
			Integer numeroTeste = heap.rootElement();
			if(this.comparator.compare(numeroProximo, (int) numero) <= 0){
				if (this.comparator.compare(numeroTeste, (int) numero) <= 0 && this.comparator.compare(numeroProximo, numeroTeste) <= 0){
					return floorRecursivo(heap, numeroTeste, numero);
				}
				else{
					heap.extractRootElement();
					return floorRecursivo(heap, numeroProximo, numero);
				}
			}
			else{
				return floorRecursivo(heap, numeroTeste, numero);
			}
		}
		else{
			return numeroProximo;
		}
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		if( array.length != 0 && array != null){
			HeapImpl<Integer> heap = new HeapImpl<>(comparator);
			for(int i = 0; i < array.length;i++){
				heap.insert(array[i]);
			}
			return ceilRecursivo(heap,heap.rootElement(),numero);
		}
		return null;
	}
	private Integer ceilRecursivo(HeapImpl<Integer> heap,Integer numeroProximo, double numero){
		heap.extractRootElement();
		if (!heap.isEmpty()){
			Integer numeroTeste = heap.rootElement();
			if(this.comparator.compare(numeroProximo, (int) numero) >= 0){
				if (this.comparator.compare(numeroTeste, (int) numero) >= 0 && this.comparator.compare(numeroProximo, numeroTeste) >= 0){
					return ceilRecursivo(heap, numeroTeste, numero);
				}
				else{
					heap.extractRootElement();
					return ceilRecursivo(heap, numeroProximo, numero);
				}
			}
			else{
				return ceilRecursivo(heap, numeroTeste, numero);
			}
		}
		else{
			return numeroProximo;
		}
	}

}
