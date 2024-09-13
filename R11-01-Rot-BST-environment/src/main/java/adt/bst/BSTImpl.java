package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> resp = null;
		if (isEmpty()){
			return resp;
		}
		else{
			BSTNode<T> auxRoot = this.root;
			while (!auxRoot.equals(null)){
				if (auxRoot.getData().equals(element)){
					resp = (BSTNode<T>) auxRoot.getData();
				}
				if (auxRoot.getData().compareTo(element) < 0){
					auxRoot = (BSTNode<T>) auxRoot.getLeft();
				}
				else{
					auxRoot = (BSTNode<T>) auxRoot.getRight();
				}
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()){
			this.root.setData(element);
		}
		else{
			BSTNode<T> auxRoot = this.root;
			while (!auxRoot.equals(null)){
				if(auxRoot.getData().compareTo(element) < 0){
					if (auxRoot.getLeft().equals(null)){
						auxRoot.setLeft(new BTNode<T>(element,new BSTNode<>(),new BSTNode<>(),auxRoot));
						break;
					}
					auxRoot = (BSTNode<T>) auxRoot.getLeft();
				}
				else{
					if (auxRoot.getRight().equals(null)){
						auxRoot.setRight(new BTNode<T>(element,new BSTNode<>(),new BSTNode<>(),auxRoot));
						break;
					}
					auxRoot = (BSTNode<T>) auxRoot.getRight();
				}
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
