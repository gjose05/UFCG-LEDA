package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

    @Override
    public void sort(T[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivot = mediana(array, leftIndex, rightIndex);
            swap(array, pivot, rightIndex - 1);
            int cr = corta(array, leftIndex, rightIndex - 1);
            swap(array, cr, rightIndex - 1);
            sort(array, leftIndex, cr - 1);
            sort(array, cr + 1, rightIndex);
        }
    }
    private int mediana(T[] array, int leftIndex, int rightIndex) {
        int meio = (leftIndex + rightIndex) / 2;
        if (array[leftIndex].compareTo(array[meio]) > 0) {
            swap(array, leftIndex, meio);
        }
		if (array[meio].compareTo(array[rightIndex]) > 0) {
            swap(array, meio, rightIndex);
        }
        if (array[leftIndex].compareTo(array[rightIndex]) > 0) {
            swap(array, leftIndex, rightIndex);
        }
        return meio;
    }
    private int corta(T[] array, int leftIndex, int rightIndex) {
        T pivot = array[rightIndex];
        int i = leftIndex;
        for (int j = leftIndex; j < rightIndex; j++) {
            if (array[j].compareTo(pivot) < 0) {
                swap(array, i, j);
                i++;
            }
        }
        return i;
    }
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
