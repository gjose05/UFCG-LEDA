package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

    protected DoubleLinkedListNode<T> last;

    @Override
    public void insert(T element) {
        if (isEmpty()) {
            DoubleLinkedListNode<T> novoLast = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), last);
            last = novoLast;
            head = novoLast;
        } else {
            insertRecursive(element, this.last);
        }
    }

    private void insertRecursive(T element, DoubleLinkedListNode<T> node) {
        if (node.getNext().isNIL()) {
            DoubleLinkedListNode<T> novoLast = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), node);
            node.setNext(novoLast);
            last = novoLast;
        } else {
            insertRecursive(element, (DoubleLinkedListNode<T>) node.getNext());
        }
    }

    @Override
    public T search(T element) {
        return searchRecursive(element, this.head, this.last);
    }

    private T searchRecursive(T element, SingleLinkedListNode<T> headNode, DoubleLinkedListNode<T> lastNode) {
        if (headNode == null || headNode.isNIL() || lastNode == null || lastNode.isNIL()) {
            return null;
        }
        if (headNode.getData().equals(element) || lastNode.getData().equals(element)) {
            return element;
        }
        if (headNode == lastNode || headNode.getNext() == lastNode) {
            return null;
        }
        return searchRecursive(element, headNode.getNext(), lastNode.getPrevious());
    }

    @Override
    public void remove(T element) {
        if (isEmpty()) {
            return;
        }
        if (head.getData().equals(element)) {
            removeFirst();
        } else {
            removeRecursive(element, (DoubleLinkedListNode<T>) getHead());
        }
    }

    private void removeRecursive(T element, DoubleLinkedListNode<T> node) {
        if (node == null || node.isNIL()) {
            return;
        }
        if (node.getData().equals(element)) {
            if (node == head) {
                removeFirst();
            } else if (node == last) {
                removeLast();
            } else {
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
            }
        } else {
            removeRecursive(element, (DoubleLinkedListNode<T>) node.getNext());
        }
    }

    @Override
    public void insertFirst(T element) {
        DoubleLinkedListNode<T> novoHead = new DoubleLinkedListNode<>(element, (DoubleLinkedListNode<T>) head, new DoubleLinkedListNode<>());
        if (head.getData() == null) {
            last = novoHead;
        }
        head = novoHead;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            return;
        } else {
            setHead(head.getNext());
            if (head.getData() == null) {
                last = (DoubleLinkedListNode<T>) head;
            } else {
                head.setPrevious(new DoubleLinkedListNode<>());
            }
        }
    }

    @Override
    public void removeLast() {
        if (isEmpty()) {
            return;
        } else {
            last = last.getPrevious();
            if (last.getData() == null) {
                head = last;
            } else {
                last.setNext(new DoubleLinkedListNode<>());
            }
        }
    }

    public DoubleLinkedListNode<T> getLast() {
        return last;
    }

    public void setLast(DoubleLinkedListNode<T> last) {
        this.last = last;
    }
}
