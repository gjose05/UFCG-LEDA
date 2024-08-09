package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	
	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if ( leftIndex < rightIndex){
			int menor = menor(array, leftIndex, rightIndex);
			int maior = maior(array,leftIndex,rightIndex);
			int[] arrayCopia;
			if (menor<0){
				arrayCopia = new int[maior-menor];
			}
			else{
				arrayCopia = new int[maior];
			}
			for (int i = leftIndex; i <= rightIndex; i++){
				if (menor < 0){
					arrayCopia[array[i]-menor-1]++;
				}
				else{
					arrayCopia[array[i]]++;
				}
			}
			int contadorPosicoes = 0;
			for(int i = 0; i <= arrayCopia.length-1; i++){
				while(arrayCopia[i] != 0){
					if (arrayCopia[i] + menor < 0){
						array[contadorPosicoes] = i + menor + 1 ;
						contadorPosicoes++;
						arrayCopia[i]--;
					}
					else{
						array[contadorPosicoes] = i + menor  ;
						contadorPosicoes++;
						arrayCopia[i]--;
					}
				}
			}
		}
	}
	private int maior(Integer[] array, int leftIndex, int rightIndex){
		int maior = array[leftIndex];
		for (int i = leftIndex+1; i <= rightIndex; i++){
			if (array[i] > maior){
				maior = array[i];
			}
		}
		return maior+1;
	}
	private int menor(Integer[] array, int leftIndex, int rightIndex){
		int menor = array[leftIndex];
		for (int i = leftIndex+1; i <= rightIndex; i++){
			if (array[i] < menor){
				menor = array[i];
			}
		}
		return menor-1;
	}

}
