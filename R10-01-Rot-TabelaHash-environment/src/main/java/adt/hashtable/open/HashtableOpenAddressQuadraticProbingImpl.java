package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (! isFull() || element != null){
			int probe = 0;
			while (probe < this.capacity()){
				int posicao = ((HashFunctionQuadraticProbing)this.hashFunction).hash(element,probe);
				if (this.table[posicao] == null || this.table[posicao].equals(deletedElement)){
					this.table[posicao] = element;
					this.elements++;
					break;
				}
				else if(this.table[posicao].equals(element)){
				}
				else{
					this.COLLISIONS++;
					probe++;
				}
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null){
			int posicao = indexOf(element);
			if (posicao != -1){
				this.table[posicao] = deletedElement;
				this.elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		T resp = null;
		if (element != null){
			int probe = 0;
			while (probe < this.capacity()){
				int posicao = ((HashFunctionQuadraticProbing)this.hashFunction).hash(element,probe);
				if (this.table[posicao] == null){
					break;
				}
				if (this.table[posicao].equals(element)){
					resp = element;
					break;
				}
				else{
					probe++;
				}
			}
		}
		return resp;
	}

	@Override
	public int indexOf(T element) {
		int resp = -1;
		if (element != null){
			int probe = 0;
			while (probe < this.capacity()){
				int posicao = ((HashFunctionQuadraticProbing)this.hashFunction).hash(element,probe);
				if(this.table[posicao] == null){
					break;
				}
				if(this.table[posicao].equals(element)){
					resp = posicao;
					break;
				}
				else{
					probe++;
				}
			}
		}
		return resp;
	}
}
