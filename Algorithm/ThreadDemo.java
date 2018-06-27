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
		System.out.println(">>>>>>>>" + taskNum + "任务启动");
		Date date1 = new Date();
		Thread.sleep(1000);
		Date date2 = new Date();
		long time = date2.getTime() - date1.getTime();
		System.out.println(">>>>>>>>" + taskNum + "任务终止");
		return taskNum + "任务返回运行结果，当前任务时间" + "[" + time + "ms]";
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
		System.out.println("------程序开始运行---------");
		Date date1 = new Date();
		
		int taskSize = 5;
		//创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		
		//创建多个有返回值的任务
		List<Future> list = new ArrayList<Future>();
		for ( int i = 0 ; i < taskSize ; i++ ) {
			Callable c = new CallableClass(i+" ");
			//执行任务并获取Future对象
			Future f = pool.submit(c);
			
			list.add(f);
		}
		
		//关闭线程池
		pool.shutdown();
		
		//获取所有并发任务的运行结果
		for ( Future f : list ) {
			System.out.println(">>>>>" + f.get().toString());
		}
	}
}
