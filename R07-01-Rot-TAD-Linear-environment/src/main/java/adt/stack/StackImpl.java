package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T resp = null;
		if (top != -1){
			resp = array[top];
		}
		return resp;
	}

	@Override
	public boolean isEmpty() {
		boolean resp = true;
		if (top != -1){
			resp = false;
		}
		return resp;
	}

	@Override
	public boolean isFull() {
		boolean resp = false;
		if (top == array.length-1){
			resp = true;
		}
		return resp;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!isFull()){
			top++;
			array[top] = element;
		}
		else{
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!isEmpty()){
			T resp = array[top];
			array[top] = null;
			top--;
			return resp;
		}
		else{
			throw new StackUnderflowException();
		}
	}

}
