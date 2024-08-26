package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (!stack1.isFull()){
			try {
				stack1.push(element);
			} catch (StackOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (stack2.isEmpty()){
			while (!stack1.isEmpty()){
				try {
					stack2.push(stack1.pop());
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (stack2.isEmpty()){
			throw new QueueUnderflowException();
		}
		T resp = null;
		try {
			resp = stack2.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resp;
	}

	@Override
	public T head() {
		if (stack2.isEmpty()){
			while (!stack1.isEmpty()){
				try {
					stack2.push(stack1.pop());
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (StackUnderflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return stack2.top();
	}

	@Override
	public boolean isEmpty() {
		boolean resp = false;
		if (stack1.isEmpty() && stack2.isEmpty()){
			resp = true;
		}
		return resp;
	}

	@Override
	public boolean isFull() {
		boolean resp = false;
		if (stack1.isFull()){
			resp = true;
		}
		return resp;
	}

}
