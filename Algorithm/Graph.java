package com.fpc.Test;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Graph {
	private int number;
	private boolean[] flag;
	private String[] vertex;
	private int[][] edges;
	
	public Graph( String[] vertex , int[][] edges ) {
		number = vertex.length;
		this.vertex = vertex;
		this.edges = edges;
	}
	
	//DFS 递归
	public void DFSRecursion() {
		flag = new boolean[number];
		for ( int j = 0 ; j < number ; j++ ) {
			if ( !flag[j] ) {
				DFS(j);
			}
		}
	}
	
	public void DFS( int index ) {
		flag[index] = true;
		System.out.print( vertex[index] + " ");
		for ( int j = 0 ; j < number ; j++ ) {
			if ( edges[index][j] == 1 && !flag[j] ) {
				DFS(j);
			}
		}
	}
	
	//DFS非递归版
	public void DFS_Stack() {
		flag = new boolean[number];
		Stack<Integer> stack = new Stack<Integer>();
		for ( int i = 0 ; i < number ; i++ ) {
			if ( !flag[i] ) {
				flag[i] = true;
				System.out.print( vertex[i] + " ");
				stack.push(i);
				
				while ( !stack.isEmpty() ) {
					int index = stack.pop();
					for ( int j = 0 ; j < number ; j++ ) {
						if ( !flag[j] && edges[index][j] == 1 ) {
							flag[j] = true;
							System.out.print( vertex[j] + " ");
							stack.push(j);
							break;
						}
					}
				}
				
			}
		}
	}
	
	//DFS1
	public void DFS1() {
		flag = new boolean[number];
		for ( int i = 0 ; i < number ; i++ ) {
			if ( !flag[i] ) {
				flag[i] = true;
				System.out.print( vertex[i] + " ");
				DFS11(i);
			}
		}
	}
	
	public void DFS11( int index) {
		for ( int i = 0 ; i < number ; i++ ) {
			if ( !flag[i] && edges[index][i] == 1 ) {
				flag[i] = true;
				System.out.print( vertex[i] + " ");
				DFS11(i);
			}
		}
	}
	
	public void DFS2() {
		flag = new boolean[number];
		Stack<Integer> stack = new Stack<Integer>();
		for ( int i = 0 ; i < number ; i++ ) {
			if ( !flag[i] ) {
				flag[i] = true;
				System.out.print( vertex[i] + " ");
				stack.push(i);
			}
			while ( !stack.isEmpty() ) {
				int index = stack.pop();
				for ( int j = 0 ; j < number ; j++ ) {
					if ( !flag[j] ) {
						flag[j] = true;
						System.out.print( vertex[j] + " ");
						stack.push(j);
						break;
					}
				}
			}
		}
	}
	
	public void BFS() {
		flag = new boolean[number];
		Queue<Integer> queue = new LinkedList<Integer>();
		for ( int i = 0 ; i < number ; i++ ) {
			if ( !flag[i] ) {
				flag[i] = true;
				queue.add(i);
				System.out.print( vertex[i] + " ");
			}
			while ( !queue.isEmpty() ) {
				int index = queue.poll();
				for ( int j = 0 ; j < number ; j++ ) {
					if ( !flag[j] && edges[index][j] == 1 ) {
						flag[j] = true;
						queue.add(j);
						System.out.print( vertex[j] + " ");
					}
				}
			}
		}
	}
	public static void main( String[] args ) {
		String[] vertexs = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
		int[][] edges = {   
	            { 0, 1, 0, 0, 0, 1, 1, 0, 0 }, 
	            { 1, 0, 1, 0, 0, 0, 1, 0, 1 }, 
	            { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  
	            { 0, 0, 1, 0, 1, 0, 1, 1, 1 }, 
	            { 0, 0, 0, 1, 0, 1, 0, 1, 0 }, 
	            { 1, 0, 0, 0, 1, 0, 1, 0, 0 },  
	            { 0, 1, 0, 1, 0, 1, 0, 1, 0 }, 
	            { 0, 0, 0, 1, 1, 0, 1, 0, 0 }, 
	            { 0, 1, 1, 1, 0, 0, 0, 0, 0 }   
	            }; 
		Graph graph = new Graph( vertexs , edges);
		System.out.println("DFS递归实现：");
		graph.DFS1();
		System.out.println();
		System.out.println("DFS非递归实现：");
		graph.DFS2();
		System.out.println();
		System.out.println("BFS递归实现：");
		graph.BFS();
	}
}
