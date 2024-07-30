package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
	if (rightIndex > leftIndex){
		if (rightIndex != leftIndex){
			int menor = recursividade(array,leftIndex,rightIndex);
			Util.swap(array, leftIndex,menor);
			sort(array, leftIndex+1, rightIndex);
			}
		}
	}
	
	private int recursividade(T[] array,int leftIndex, int rightIndex){
		int menor = leftIndex;
		if (leftIndex != rightIndex){
			int menorzinho = recursividade(array,leftIndex+1,rightIndex);
			if(array[menor].compareTo(array[menorzinho])>0){
				menor = menorzinho;
			}
		}
		return menor;

	}
}
