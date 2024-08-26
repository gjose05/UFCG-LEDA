package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!isFull()){
			tail++;
			if (isEmpty()){
				head++;
			}
			if (tail == array.length){
				tail = 0;
			}
			array[tail] = element;
			this.elements++;
		}
		else{
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()){
			T result = array[head];
			head++;
			if(head == array.length){
				head = 0;
			} 
			elements--;
			return result;
		}
		else{
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		T resp = null;
		if (!isEmpty()){
			resp = array[head];
		}
		return resp;
	}

	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if(elements == 0){
			resp = true;
		}
		return resp;
	}

	@Override
	public boolean isFull() {
		boolean resp = false;
		if (elements == array.length){
			resp =  true;
		}
		return resp;
	}

}
