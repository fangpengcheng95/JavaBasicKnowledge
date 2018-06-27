package com.fpc.Test;

public class Tree {
	private Integer val;
	private Tree left;
	private Tree right;
	private Integer curSum = Integer.MIN_VALUE;
	public Tree(Integer val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public int minSumSubTree(Tree root) {
		if ( root == null ) {
			return 0;
		}
		int sum = root.val + Integer.max(minSumSubTree(root.left) , minSumSubTree(root.right));
		if ( sum >= curSum ) {
			curSum = sum;
		}
		return sum;
	}
	
	public static void main( String[] args ) {
		Tree tree = new Tree(1);
		tree.left = new Tree(2);
		tree.right = new Tree(8);
		tree.left.right = new Tree(1);
		tree.minSumSubTree(tree);
		System.out.println( tree.curSum);
	}
}
