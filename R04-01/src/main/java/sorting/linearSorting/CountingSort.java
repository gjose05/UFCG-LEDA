package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if ( leftIndex < rightIndex){
			int[] arrayCopia = new int[maior(array,leftIndex,rightIndex)];
			for (int i = leftIndex; i <= rightIndex; i++){
				arrayCopia[array[i]]++;
			}
			int contadorPosicoes = 0;
			for(int i = 0; i <= arrayCopia.length-1; i++){
				while(arrayCopia[i] != 0){
					if (arrayCopia[i] != 0){
						array[contadorPosicoes] = i;
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

}
