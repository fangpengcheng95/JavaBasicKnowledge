package com.fpc.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Topological {
	//��������ڵ���
	private static class Node{
		public Object val;
		public int pathIn = 0; //���
		public Node(Object val) {
			this.val = val;
		}
	}
	
	//����ͼ��
	private static class Graph{
		//ͼ�нڵ�ļ���
		public Set<Node> vertexSet = new HashSet<Node>();
		
		//���ڵĽڵ㣬��¼��
		public Map<Node,Set<Node>> adjNode = new HashMap<Node,Set<Node>>();
		
		//���ڵ����ͼ��
		public boolean addNode(Node start , Node end) {
			if ( !vertexSet.contains(start) ) {
				vertexSet.add(start);
			}
			
			if ( !vertexSet.contains(end) ) {
				vertexSet.add(end);
			}
			
			if ( adjNode.containsKey(start) && adjNode.get(start).contains(end) ) {
				return false;
			}
			
			if ( adjNode.containsKey(start) ) {
				adjNode.get(start).add(end);
			} else {
				Set<Node> temp = new HashSet<Node>();
				temp.add(end);
				adjNode.put(start, temp);
			}
			end.pathIn++;
			return true;
		}
	}
	
	//Kahn�㷨
	private static class KahnTopo{
		private List<Node> result;//�����洢�����
		private Queue<Node> setOfZeroIndegree;//�����洢���Ϊ0�Ķ���
		private Graph graph;
		
		//���캯������ʼ��
		public KahnTopo( Graph graph ) {
			this.graph = graph;
			this.result = new ArrayList<Node>();
			this.setOfZeroIndegree = new LinkedList<Node>();
			
			//�����Ϊ0�ļ��Ͻ��г�ʼ��
			for ( Node iterator : this.graph.vertexSet ) {
				if ( iterator.pathIn == 0 ) {
					this.setOfZeroIndegree.add(iterator);
				}
			}
		}
		
		//�������������
		private void process() {
			while ( !setOfZeroIndegree.isEmpty() ) {
				Node v = setOfZeroIndegree.poll();
				
				//����ǰ������ӵ��������
				result.add(v);
				
				if ( this.graph.adjNode.keySet().isEmpty() ) {
					return;
				}
				
				//������v���������б�
				for ( Node w : this.graph.adjNode.get(v) ) {
					//���ñߴ�ͼ���Ƴ���ͨ�����ٱߵ���������ʾ
					w.pathIn--;
					if ( w.pathIn == 0 ) {
						setOfZeroIndegree.add(w);
					}
				}
				
				this.graph.vertexSet.remove(v);
				this.graph.adjNode.remove(v);
			}
			
			//�����ʱ�����ڱߣ���ô˵��ͼ�к��л�·
			if ( !this.graph.vertexSet.isEmpty() ) {
				throw new IllegalArgumentException("Has Cycle");
			}
		
		}
		
		public Iterable<Node> getResult() {
			return result;
		}
	}
	
	public static void main( String[] args ) {
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		
		Graph graph = new Graph();
		graph.addNode(A, B);  
        graph.addNode(B, C);  
        graph.addNode(B, D);  
        graph.addNode(D, C);  
        graph.addNode(E, C);  
        graph.addNode(C, F);
        
        KahnTopo topo = new KahnTopo(graph);
		
		topo.process();
		
		for ( Node temp : topo.getResult() ) {
			System.out.print( temp.val.toString() + "------>");
		}
		
	}
	
}
