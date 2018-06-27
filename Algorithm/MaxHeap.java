package com.fpc.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap {
	private ArrayList<Integer> list;
	public MaxHeap(ArrayList<Integer> list) {
		this.list = list;
	}
	
	//�����ӡ
	public void print() {
		for ( int i = 1 ; i < list.size(); i++ ) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
	
	//������
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
	
	//ɾ�����е�ĳһ���ڵ�
	public void delete( int index ) {
		//�����һ��Ҷ�ӽڵ��ֵ����indexλ��
		list.set(index, list.get(list.size() - 1 ));
		
		//ɾ�����һ���ڵ�
		list.remove(list.size()-1);
		
		//�³�����
		heapDownRecursion(index);
	}
	
	//�³������ݹ�ʵ��
	public void heapDownRecursion( int index ) {
		int n = list.size() - 1;
		int child = -1;
		if ( index * 2 > n ) {
			//���Һ��Ӷ�������
			return;
		} else if ( index * 2 < n ) {
			//���Һ��Ӷ�����
			child = index * 2;
			if ( list.get(child) < list.get(child+1) ) {
				child += 1;
			}
		} else {
			//ֻ��������
			child = index *2;
		}
		if ( list.get(child) > list.get(index) ) {
			swap(child,index);
			heapDown(child);
		}
	}
	
	//�³������ǵݹ�ʵ��
	public void heapDown( int index ) {
		int child = 0; //�洢���ӵ�λ��
		int temp = list.get(index);
		int n = list.size() - 1;
		//�����ӵ����
		for ( ; 2 * index <= n ;) {
			child = 2 * index;
			//�ж��Ƿ����Һ���
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
	
	//�������в���Ԫ��
	public void insert( int value ) {
		if ( list.size() == 0 ) {
			list.set(0, 0);//������ײ�������Ԫ��
		}
		list.add(value);
		
		//������������
		heapUp(list.size() - 1);
	}
	
	//���������ݹ�ʵ��
	public void heapUpRecrusion( int index ) {
		if ( index > 1 ) {
			int parent = index / 2;
			if ( list.get( parent) < list.get(index) ) {
				swap(parent,index);
				heapUpRecrusion(parent);
			}
		}
	}
	
	//���������ķǵݹ�ʵ��
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
	
	//������
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
