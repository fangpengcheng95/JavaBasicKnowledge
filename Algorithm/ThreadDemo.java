package com.fpc.Test;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;


class CallableClass implements Callable<Object>{
	private String taskNum;
	public CallableClass( String taskNum ) {
		this.taskNum = taskNum;
	}
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>" + taskNum + "��������");
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime();
		System.out.println(">>>>>>>>" + taskNum + "������ֹ");
		return taskNum + "���񷵻����н������ǰ����ʱ��" + "[" + time + "ms]";
	}
	
}
public class ThreadDemo implements Runnable{
	private String threadName;
	public ThreadDemo(String threadName) {
		this.threadName = threadName;
	}
	public void run() {
		for ( int i = 0 ; i < 100 ; i++ ) {
			System.out.println(this.threadName +" " + i);
		}
	}
	public static void main(String[] args ) throws InterruptedException, ExecutionException {
		ThreadDemo th1 = new ThreadDemo("Thread1");
		System.out.println("------����ʼ����---------");
		Date date1 = new Date();
		
		int taskSize = 5;
		//����һ���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		
		//��������з���ֵ������
		List<Future> list = new ArrayList<Future>();
		for ( int i = 0 ; i < taskSize ; i++ ) {
			Callable c = new CallableClass(i+" ");
			//ִ�����񲢻�ȡFuture����
			Future f = pool.submit(c);
			
			list.add(f);
		}
		
		//�ر��̳߳�
		pool.shutdown();
		
		//��ȡ���в�����������н��
		for ( Future f : list ) {
			System.out.println(">>>>>" + f.get().toString());
		}
	}
}
