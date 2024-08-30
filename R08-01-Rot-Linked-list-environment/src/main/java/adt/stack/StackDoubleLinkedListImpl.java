package adt.stack;

import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

    private DoubleLinkedListImpl<T> list; 
    private int maxSize;  
    private int currentSize;  

    public StackDoubleLinkedListImpl(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.list = new DoubleLinkedListImpl<>();
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }
        list.insert(element); 
        currentSize++;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        T element = list.getLast().getData();
        list.removeLast(); 
        currentSize--;
        return element;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null; 
        }
        return list.getLast().getData(); 
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize >= maxSize;
    }
}
