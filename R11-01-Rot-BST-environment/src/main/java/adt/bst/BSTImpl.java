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
		if (isEmpty() || element == null){
			return resp;
		}
		else{
			resp = searchRecursive(this.root, element);
		}
		return resp;
	}
	private BSTNode<T> searchRecursive(BSTNode<T> node, T element){
		BSTNode<T> resp;
		if (node.equals(null)){
			resp = null;
		}
		else{
			if (node.getData().equals(element)){
				resp = node;
			}
			if(node.getData().compareTo(element) < 0){
				resp = searchRecursive((BSTNode<T>) node.getLeft(),element);
			}
			else{
				resp = searchRecursive((BSTNode<T>) node.getRight(),element);
			}
		}
		return resp;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()||element == null){
			this.root.setData(element);
		}
		else{
			insertRecursive(root, element);
		}
	}
	private void insertRecursive(BSTNode<T> node, T element){
		
		if (node.getData().compareTo(element) < 0){
			if (node.getLeft() == null){
				BSTNode<T> novoNode = new BSTNode<T>();
				novoNode.setLeft(new BSTNode<>());
				novoNode.setRight(new BSTNode<>());
				novoNode.setParent(node);
				novoNode.setData(element);
				node.setLeft(novoNode);
			}
			else{
				insertRecursive((BSTNode<T>) node.getLeft(), element);
			}
		}
		else{
			if (node.getRight() == null){
				BSTNode<T> novoNode = new BSTNode<T>();
				novoNode.setLeft(new BSTNode<>());
				novoNode.setRight(new BSTNode<>());
				novoNode.setParent(node);
				novoNode.setData(element);
				node.setRight(novoNode);
			}
			else{
				insertRecursive((BSTNode<T>) node.getRight(), element);
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
