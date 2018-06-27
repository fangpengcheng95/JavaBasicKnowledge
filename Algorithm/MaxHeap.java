package com.fpc.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap {
	private ArrayList<Integer> list;
	public MaxHeap(ArrayList<Integer> list) {
		this.list = list;
	}
	
	//链表打印
	public void print() {
		for ( int i = 1 ; i < list.size(); i++ ) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	//调整堆
	public void adjust() {
		for ( int index = list.size() / 2 ; index > 0 ; index-- ) {
			adjust(index,list.size() - 1 );
		}
	}
	
	public void adjust(int index , int n) {
		int child;
		for ( int i = index ; i <= n / 2 ; ) {
			child = 2 * i;
			if ( child+1 <= n && list.get(child) < list.get(child+1) ) {
				child+=1;
			}
			if (list.get(i) < list.get(child)) {
				swap(i,child);
				i = child;
			} else {
				break;
			}
		}
	}
	
	public void swap( int i , int j ) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	//删除堆中的某一个节点
	public void delete( int index ) {
		//把最后一个叶子节点的值赋在index位置
		list.set(index, list.get(list.size() - 1 ));
		
		//删除最后一个节点
		list.remove(list.size()-1);
		
		//下沉操作
		heapDownRecursion(index);
	}
	
	//下沉操作递归实现
	public void heapDownRecursion( int index ) {
		int n = list.size() - 1;
		int child = -1;
		if ( index * 2 > n ) {
			//左右孩子都不存在
			return;
		} else if ( index * 2 < n ) {
			//左右孩子都存在
			child = index * 2;
			if ( list.get(child) < list.get(child+1) ) {
				child += 1;
			}
		} else {
			//只存在左孩子
			child = index *2;
		}
		if ( list.get(child) > list.get(index) ) {
			swap(child,index);
			heapDown(child);
		}
	}
	
	//下沉操作非递归实现
	public void heapDown( int index ) {
		int child = 0; //存储儿子的位置
		int temp = list.get(index);
		int n = list.size() - 1;
		//有左孩子的情况
		for ( ; 2 * index <= n ;) {
			child = 2 * index;
			//判断是否有右孩子
			if ( child+1 <= n && list.get(child) < list.get(child+1) ) {
				child++;
			}
			if ( list.get(index) < list.get(child) ) {
				swap(index,child);
				index = child;
			} else {
				break;
			}
		}
	}
	
	//向最大堆中插入元素
	public void insert( int value ) {
		if ( list.size() == 0 ) {
			list.set(0, 0);//链表的首部不放置元素
		}
		list.add(value);
		
		//进行上升操作
		heapUp(list.size() - 1);
	}
	
	//上升操作递归实现
	public void heapUpRecrusion( int index ) {
		if ( index > 1 ) {
			int parent = index / 2;
			if ( list.get( parent) < list.get(index) ) {
				swap(parent,index);
				heapUpRecrusion(parent);
			}
		}
	}
	
	//上升操作的非递归实现
	public void heapUp( int index ) {
		for ( ; index > 1 ;) {
			int parent = index / 2;
			if ( list.get(parent) < list.get(index)  ) {
				swap(index,parent);
				index = parent;
			} else {
				break;
			}
		}
	}
	
	//堆排序
	public void heapSort() {
		for ( int i = list.size() - 1 ; i >= 1 ; i-- ) {
			swap(1,i);
			adjust(1,i-1);
		}
	}
	public static void main( String[] args ) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(null,1, 2, 5, 10, 3, 7, 11, 15, 17, 20, 9, 15, 8, 16));
		MaxHeap maxHeap = new MaxHeap(list);
		maxHeap.print();
		maxHeap.adjust();
		maxHeap.print();
		maxHeap.delete(8);
		maxHeap.print();
		maxHeap.insert(99);
		maxHeap.print();
		maxHeap.heapSort();
		maxHeap.print();
	}
}
