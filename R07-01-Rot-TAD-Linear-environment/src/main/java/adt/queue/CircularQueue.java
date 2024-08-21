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
		tail++;
		if (head == -1){
			head++;
		}
		if (tail == array.length){
			tail = head;
		}
		array[tail] = element;
		elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()){
			T result  = array[tail];
			for (int i = 0; i < tail;i++){
				array[i] = array[i+1];
			}
			tail--;
			return result;
		}
		else{
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		if (!isEmpty()){
			return array[head];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(head == -1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (elements >= array.length-1){
			return true;
		}
		return false;
	}

}
