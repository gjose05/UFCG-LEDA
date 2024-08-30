package adt.linkedList;

import java.lang.reflect.Array;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	public int size() {
		int contador = 0;
		SingleLinkedListNode<T> no = this.head;
		while (no != null && !no.isNIL()) {
			contador++;
			no = no.getNext();
		}
		return contador;
	}

	@Override
	public T search(T element) {
		if (!(element.equals(null)) && !(this.head.isNIL())){
			SingleLinkedListNode<T> no = this.head;
			while(!(no.isNIL())){
				if (no.getData().equals(element)){
					return no.getData();
				}
				no = no.getNext();
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (!(element.equals(null))){
			SingleLinkedListNode<T> no = this.head;
			SingleLinkedListNode<T> novohead = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<>());
			if (this.head.isNIL()){
				setHead(novohead);
			}
			else{
				while(!(no.getNext().isNIL())){
					no = no.getNext();
				}
				no.setNext(novohead);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (!(element.equals(null)) && !(this.head.isNIL())){
			SingleLinkedListNode<T> no = this.head;
			while (!(no.getData().equals(element)) && !(no.isNIL())){
				no = no.getNext();
			}
			no.setData(no.getNext().getData()); 
			no.setNext(no.getNext().getNext()); 
		}
	}

	@Override
	public T[] toArray() {
    T[] array = (T[]) new Object[this.size()];
    SingleLinkedListNode<T> node = this.head;
    int index = 0;

    while (node != null && !node.isNIL()) {
        array[index++] = node.getData();
        node = node.getNext();
    }

    return array;
}


	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
