package com.fpc.Test;

import java.util.*;   

/** 
 *ʵ�ֵ����ѵĲ����ɾ������ 
 * @author Arthur 
 */   
public class Heap {   
     /** 
     * ɾ������λ����index����ֵ 
     * ����ԭ���ǣ���ɾ���ڵ����ֵʱ��ԭ����λ�þͻ����һ���� 
     * �������׵ķ������ǣ�������Ҷ�ӵ�ֵ�����ÿף����Ѹ�Ҷ��ɾ�� 
     * @param heap һ������ 
     */   
    public static void delete(List<Integer> heap,int index) {   
        //������һ��Ҷ�ӵ���ֵ��ֵ��indexλ��   
        heap.set(index, heap.get(heap.size() - 1));   
        //�³�����   
        //heapDown2(heap, index);   
        heapDown(heap, index); //�ڵ��³�  
        //�����һ��λ�õ�����ɾ��   
        heap.remove(heap.size() - 1);   
    }   
    /**  
     * �ڵ��³��ݹ�ʵ�� 
     * ɾ��һ������һ�����ݵ�ʱ�򣬸��ݶѵ����ʣ�Ӧ�ð���Ӧ��λ�����ƣ����ܱ���ס�����ʲ��� 
     * @param heap ��������Ԫ�ص����� 
     * @param index ��ɾ�����Ǹ��ڵ��λ�� 
     */   
    public static void heapDown(List<Integer> heap, int index) {   
        //��Ϊ��һ��λ�ô洢���ǿ�ֵ�����ڿ���֮��   
        int n = heap.size() - 2;   
   
        //��¼�����Ǹ����ӽڵ��λ��   
        int child = -1;   
        
        //2*index>n˵���ýڵ�û�����Ҷ��ӽڵ��ˣ���ô�ͷ���   
        if (2 * index > n) {   
            return;   
        } //������Ҷ��Ӷ�����   
        else if (2 * index < n) {   
   
            //��������ӽڵ�   
            child = 2 * index;   
            //��������С���Ҷ��ӵ���ֵ��ȡ�Ҷ��ӵ��±�   
            if ((Integer) heap.get(child) < (Integer) heap.get(child + 1)) {   
                child++;   
            }   
   
        }//���ֻ��һ�����ӣ�����ӽڵ㣩   
        else if (2 * index == n) {   
            child = 2 * index;   
        }   
   
        if ((Integer) heap.get(child) > (Integer) heap.get(index)) {   
            //�������е�child����indexλ�õ�ֵ   
            swap(heap, child, index);   
   
            //��ɽ�����ݹ���ã������½�   
            heapDown(heap, child);   
        }   
    }   
   
    //�ǵݹ�ʵ��   
    public static void heapDown2(List<Integer> heap, int index) {   
        int child = 0;//�洢����ӵ�λ��   
   
        int temp = (Integer) heap.get(index);   
        int n = heap.size() - 2;   
        //����ж��ӵĻ�   
        for (; 2 * index <= n; index = child) {   
            //��ȡ����ӵ�λ��   
            child = 2 * index;   
            //���ֻ�������   
            if (child == n) {   
                child = 2 * index;   
            } //����Ҷ��ӱ�����ӵ���ֵ��   
            else if ((Integer) heap.get(child) < (Integer) heap.get(child + 1)) {   
                child++;   
            }   
   
            //�����ֵ���Ķ��ӱ�temp��ֵ��   
            if ((Integer) heap.get(child) >temp) {   
                //�������е�child����indexλ�õ�ֵ   
                swap(heap, child, index);   
            } else {   
                break;   
            }   
        }   
    }   
   
      
     //��ӡ����   
    public static void print(List<Integer> list) {   
        for (int i = 1; i < list.size(); i++) {   
            System.out.print(list.get(i) + " ");   
        }   
        System.out.println();  
    }   
   
    //�Ѷ��е�a,bλ�õ�ֵ����   
    public static void swap(List<Integer> heap, int a, int b) {   
        //��ʱ�洢childλ�õ�ֵ   
        int temp = (Integer) heap.get(a);   
   
        //��index��ֵ����child��λ��   
        heap.set(a, heap.get(b));   
   
        //��ԭ����childλ�õ���ֵ��ֵ��indexλ��   
        heap.set(b, temp);   
    }   
   
    //�������в���Ԫ��   
    public static void insert(List<Integer> heap, int value) {   
           //�������β�����Ҫ�����Ԫ��  
        if(heap.size()==0)  
          heap.add(0);//�����±�Ϊ0��λ�ò���Ԫ��  
        heap.add(value);   
        //��ʼ��������   
       // heapUp2(heap, heap.size() - 1);   
        heapUp(heap, heap.size() - 1);   
   
    }   
   
    //�ڵ��ϸ����ò�������͸��ڵ����ֵ�Ƚϣ������ڸ��ڵ��ʱ��ͺͽڵ��ֵ�ཻ��   
    public static void heapUp(List<Integer> heap, int index) {   
   
        //ע��������ֵ�Ǵ�С��Ϊһ��ʼ����index = 1��ʱ���Ѿ��Ǹ��ڵ���   
        if (index > 1) {   
            //���游�׵Ľڵ�   
            int parent = index / 2;   
   
            //��ȡ��Ӧλ�õ���ֵ   
            int parentValue = (Integer) heap.get(parent);   
            int indexValue = (Integer) heap.get(index);   
            //������׽ڵ��index����ֵС���ͽ������ߵ���ֵ   
            if (parentValue < indexValue) {   
                //������ֵ   
                swap(heap, parent, index);   
                //�ݹ����   
                heapUp(heap, parent);   
            }   
   
        }   
    }   
   
    //�ǵݹ�ʵ��   
    public static void heapUp2(List<Integer> heap, int index) {   
        int parent = 0;   
        for (; index > 1; index /= 2) {   
            //��ȡindex�ĸ��ڵ���±�   
            parent = index / 2;   
   
            //��ø��ڵ��ֵ   
            int parentValue = (Integer) heap.get(parent);   
            //���indexλ�õ�ֵ   
            int indexValue = (Integer) heap.get(index);   
               
            //���С�ھͽ���   
            if (parentValue < indexValue) {   
                swap(heap, parent, index);   
            }   
        }   
    }   
     /*�����������ʽ��ѣ����ڵ�ǰһ��һ���Ƿ�֧�ڵ㣬���к��ӵģ��������Ǵ����￪ʼ��������ʼ��*/    
     public static void adjust(List<Integer> heap){  
        for (int i = heap.size() / 2; i > 0; i--)    
            adjust(heap,i, heap.size()-1);    
            
        System.out.println("=================================================");  
        System.out.println("������ĳ�ʼ�ѣ�");  
          print(heap);  
      }  
    /**  
     * �����ѣ�ʹ������ѵö���  
     * @param i  
     * @param n  
     */    
    public static void adjust(List<Integer> heap,int i, int n) {    
         
        int child;    
        for (; i <= n / 2; ) {    
            child = i * 2;    
            if(child+1<=n&&heap.get(child)<heap.get(child+1))    
                child+=1;/*ʹchildָ��ֵ�ϴ�ĺ���*/    
            if(heap.get(i)< heap.get(child)){    
                swap(heap,i, child);    
                /*��������childΪ����������һ������Ѷ��壬���Դ�child����ʼ����*/    
                i = child;    
                 
            }  else break;  
        }    
    }    
    
   //��һ������heap����  
    public static void heapSort(List<Integer> heap) {    
         
        for (int i = heap.size()-1; i > 0; i--) {    
        /*�Ѹ��ڵ�����һ��Ԫ�ؽ���λ�ã�����ʣ�µ�n-1���ڵ㣬�����ź���*/    
            swap(heap,1, i);    
            adjust(heap,1, i - 1);    
        }    
    }    
   public static void main(String args[]) {   
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(null,1, 2, 5, 10, 3, 7, 11, 15, 17, 20, 9, 15, 8, 16));  
        adjust(array);//����ʹarray��Ϊ����  
         
        delete(array,8);//����ɾ���±���8��Ԫ��  
        System.out.println("ɾ����");  
        print(array);  
        insert(array, 99);//���в���  
        print(array);   
        heapSort(array);//����  
        System.out.println("���������:");  
        print(array);  
        System.out.println("-------------------------");  
        List<Integer> array1=new ArrayList<Integer>();  
        insert(array1,0);  
        insert(array1, 1);insert(array1, 2);insert(array1, 5);  
        insert(array1, 10);insert(array1, 3);insert(array1, 7);  
        insert(array1, 11);insert(array1, 15); insert(array1, 17);  
        insert(array1, 20);insert(array1, 9);  
        insert(array1, 15);insert(array1, 8);insert(array1, 16);  
        print(array1);  
          
        System.out.println("==============================");  
        array=new ArrayList<Integer>(Arrays.asList(null,45,36,18,53,72,30,48,93,15,35));  
        adjust(array);  
          insert(array, 80);//���в���  
          print(array);  
         delete(array,2);//����ɾ��80��Ԫ��  
         print(array);  
         delete(array,2);//����ɾ��72��Ԫ��  
         print(array);  
    }   
}   