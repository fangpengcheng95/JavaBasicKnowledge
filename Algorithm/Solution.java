package com.fpc.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
//	从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
//	二叉树的层序遍历
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    Queue queue = new LinkedList<TreeNode>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList list = new ArrayList<Integer>();
    if ( pRoot == null ) {
    	return res;
    } else {
    	int toBePrinted = 1;
    	int nextBePrinted = 0;
    	queue.add(pRoot);
    	while ( !queue.isEmpty() ) {
    		TreeNode temp = (TreeNode) queue.poll();
    		list.add(temp.val);
    		toBePrinted--;
    		if ( temp.left != null ) {
    			queue.add(temp.left);
    			nextBePrinted++;
    		}
    		if ( temp.right != null ) {
    			queue.add(temp.right);
    			nextBePrinted++;
    		}
    		if ( toBePrinted == 0 ) {
    			res.add(list);
    			toBePrinted = nextBePrinted;
    			nextBePrinted = 0;
    			list = new ArrayList<Integer>();
    		}
    	}
    	return res;
    }
    }
    
	ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
		Stack<TreeNode> stack1 = new Stack<TreeNode>(); //存奇数层节点
		Stack<TreeNode> stack2 = new Stack<TreeNode>(); //存偶数层节点
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if ( pRoot == null ) {
			return res;
		}
		stack1.add(pRoot);
		int layer = 1;
		while ( !stack1.isEmpty() || !stack2.isEmpty() ) {
			if ( layer % 2 == 1 ) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				while ( !stack1.isEmpty() ) {
					TreeNode node = stack1.pop();
					list.add(node.val);
					if ( node.left != null ) {
						stack2.add(node.left);
					}
					
					if ( node.right != null ) {
						stack2.add(node.right);
					}
					
					if ( stack1.isEmpty() ) {
						res.add(list);
					}
				}
				
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				while ( !stack2.isEmpty() ) {
					TreeNode node = stack2.pop();
					list.add(node.val);
					if ( node.right != null ) {
						stack1.add(node.right);
					}
					
					if ( node.left != null ) {
						stack1.add(node.left);
					}
					
					if ( stack2.isEmpty() ) {
						res.add(list);
					}
				}
			}
			layer++;
		}
		return res;
	}
	
    public static void main( String[] args ) {
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(4);
    	root.left.left = new TreeNode(3);
    	root.left.left.right = new TreeNode(2);
    	ArrayList<ArrayList<Integer>> list = new Solution().Print1(root);
    	System.out.println(list);
    }
    
}