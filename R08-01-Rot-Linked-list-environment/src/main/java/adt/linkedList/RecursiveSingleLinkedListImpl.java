package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return data == null;
	}

	@Override
	public int size() {
		if (isEmpty()){
			return 0;
		}
		else{
			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		if (isEmpty()){
			return null;
		}
		if (data.equals(element)){
			return data;
		}
		else{
			return next.search(element);
		}
	}

	@Override
	public void insert(T element) {
		if (isEmpty()){
			data = element;
			next = new RecursiveSingleLinkedListImpl<T>();
		}
		else{
			if (next.getData() == null){
				next.setData(element);
				RecursiveSingleLinkedListImpl<T> novoNext = new RecursiveSingleLinkedListImpl<T>();
				next.setNext(novoNext);
			}
			else{
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (isEmpty() || element == null){
			throw new IllegalArgumentException();
		}
		else{
			if (data.equals(element)){
				setData(next.getData());
				setNext(next.getNext());
			}
			else{
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		if (isEmpty()){
			return array;
		}
		array[0] = data;
		encheArray(this.next, array, 1);
		return array;
	}
	private void encheArray(RecursiveSingleLinkedListImpl<T> no, T[] array, int indice){
		if (no.getData() == null){
			return;
		}
		else{
			array[indice] = no.getData();
			encheArray(no.getNext(), array, indice+1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
