package vetor;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Object[this.tamanho];
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[indice+1] = o;
		indice++;
	}

	public boolean existe(T o){
		for (int i = 0 ; i < arrayInterno.length ; i++){
			if ((arrayInterno[i]!= null)&&(arrayInterno[i].equals(o))){
				return true;
			}
		}
		return false;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		for (int i = 0 ; i < arrayInterno.length ; i++){
			if (existe(o) == true){
				arrayInterno[i] = null;
			}
		}
		return null;
	}

	// Procura um elemento no vetor
	public Object procurar(T o) {
		if (existe(o) == true){
			return o;
		}
		return null;

	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		if (indice == -1){
			return true;
		}
		return false;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		if (this.arrayInterno.length == tamanho){
			return true;
		}
		return false;
	}

}
