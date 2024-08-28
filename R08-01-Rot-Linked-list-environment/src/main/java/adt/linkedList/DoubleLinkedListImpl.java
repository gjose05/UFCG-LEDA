package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		SingleLinkedListNode<T> headAnterior = getHead();
		if (!(element.equals(null))){
			SingleLinkedListNode<T> novoHead = new SingleLinkedListNode<T>(element, headAnterior);
			setHead(novoHead);
		}
	}

	@Override
	public void removeFirst() {
		SingleLinkedListNode<T> headAnterior = getHead();
		SingleLinkedListNode<T> novoHead = headAnterior.getNext();
		headAnterior = null;
		setHead(novoHead);
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
