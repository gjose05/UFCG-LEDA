package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (!isEmpty()){
			return array[0];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (tail == -1){
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if (tail == array.length-1){
			return true;
		}
		return false;
	}

	private void shiftLeft() {
		for (int i = 0; i < tail;i++){
			array[i] = array[i+1];
		}
		tail--;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!isFull()){
			tail = tail++;
			array[tail] = element;
		}
		else{
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (!isEmpty()){
			T result = array[0];
			shiftLeft();		
			return result;
		}
		else{
			throw new QueueUnderflowException();
		}
	}

}
