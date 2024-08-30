package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected DoubleLinkedListNode<T> last;

    @Override
    public void insert(T element) {
        DoubleLinkedListNode<T> novoLast = new DoubleLinkedListNode<>(element, null, last);
        if (isEmpty()) {
            head = novoLast;
            last = novoLast;
        } else {
            last.setNext(novoLast);
            last = novoLast;
        }
    }

    @Override
    public T search(T element) {
        if (isEmpty()) {
            return null;
        }

        DoubleLinkedListNode<T> current = (DoubleLinkedListNode<T>) head;
        while (current != null) {
            if (current.getData().equals(element)) {
                return element;
            }
            current = (DoubleLinkedListNode<T>) current.getNext();
        }

        return null;
    }

    @Override
    public void remove(T element) {
        if (isEmpty()) {
            return;
        }

        DoubleLinkedListNode<T> current = (DoubleLinkedListNode<T>) head;
        while (current != null) {
            if (current.getData().equals(element)) {
                if (current == head) {
                    removeFirst();
                } else if (current == last) {
                    removeLast();
                } else {
                    current.getPrevious().setNext(current.getNext());
                    current.getNext().setPrevious(current.getPrevious());
                }
                return;
            }
            current = (DoubleLinkedListNode<T>) current.getNext();
        }
    }

    @Override
    public void insertFirst(T element) {
        DoubleLinkedListNode<T> novoHead = new DoubleLinkedListNode<>(element, (DoubleLinkedListNode<T>) head, null);
        if (isEmpty()) {
            last = novoHead;
        } else {
            ((DoubleLinkedListNode<T>) head).setPrevious(novoHead);
        }
        head = novoHead;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }

        if (head == last) { 
            head = null;
            last = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
    }

    @Override
    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        if (head == last) { 
            head = null;
            last = null;
        } else {
            last = last.getPrevious();
            last.setNext(null);
        }
    }

    public DoubleLinkedListNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }
}
