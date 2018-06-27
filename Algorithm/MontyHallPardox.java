package com.fpc.Test;

import java.util.ArrayList;
import java.util.Random;

public class MontyHallPardox {
	public static int openOneDoor( boolean[] door,int mychoice ) {
		int index;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove((Integer)mychoice);
		while(true){
			Random random = new Random();
			index = random.nextInt(3);
			if ( !door[index] ) {
				break;
			}
		}
		return list.get(index);
	}
	
	public static int changeChoice( boolean[] door,int mychoice ,int hostchoice) {
		int index;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove((Integer)mychoice);
		list.remove((Integer)hostchoice);
		Random random = new Random();
		index = random.nextInt(2);
		return list.get(index);
	}
	
	public static void main( String[] args ) {
		int count = 0;
		for ( int i = 0 ; i < 10000 ; i++ ) {
			boolean[] door = {false,false,false,false};
			Random random = new Random();
			int n = random.nextInt(4);
			door[n] = true;
			
			int mychoice = random.nextInt(4);
			int hostChoice = openOneDoor(door,mychoice);
			//������ѡ����н�����
//			if( door[mychoice] ) {
//				count++;
//			}
			
			//����ѡ��
			int anotherchoice = changeChoice(door,mychoice,hostChoice);
			if ( door[anotherchoice] ) {
				count++;
			}
		}
		double ration = count/10000.0;
		System.out.println("����ѡ�������µ��н�����Ϊ�� " + ration);
	}
}
