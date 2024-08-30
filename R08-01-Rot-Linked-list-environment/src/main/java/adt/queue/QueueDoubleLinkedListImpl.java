package adt.queue;

import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

    private DoubleLinkedListImpl<T> list;
    private int size;
    private int maxSize;

    public QueueDoubleLinkedListImpl(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.list = new DoubleLinkedListImpl<>();
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException();
        }
        list.insert(element); 
        size++;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
		T element = list.getHead().getData();
        list.removeFirst();
        size--;
        return element;
    }

    @Override
    public T head() {
        if (isEmpty()) {
            return null; 
        }
        return list.getHead().getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size >= maxSize;
    }
}
