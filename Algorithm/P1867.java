package com.fpc.Test;

import java.util.*;  
class P1867{  
    static int[] next=new int[100005];  
    public static void main(String args[]){  
        int n,m,i,len1,len2;  
        String str1,str2;  
        Scanner sc=new Scanner(System.in);  
        while(sc.hasNext()){  
            str1=sc.next();  
            str2=sc.next();  
            len1=str1.length();  
            len2=str2.length();  
            n=kmp(str1,str2);  
            m=kmp(str2,str1);  
            if(n==m){  
                if(str1.compareTo(str2)>0){  
                    System.out.println(str2+str1.substring(n,len1));  
                }else{  
                    System.out.println(str1+str2.substring(n,len2));  
                }  
            }else if(n>m){  
                System.out.println(str1+str2.substring(n,len2));  
            }else{  
                System.out.println(str2+str1.substring(m,len1));  
            }  
        }  
    }  
    public static void set_next(String str){  
        int i=0,j=-1;  
        next[0]=-1;  
        int len=str.length();  
        while(i<len){  
            if(j==-1||str.charAt(i)==str.charAt(j)){  
                i++;  
                j++;  
                next[i]=j;///System.out.print(next[i]+" ");  
            }else{  
                j=next[j];  
            }  
        }  
        //System.out.println();  
    }  
    public static int kmp(String str1,String str2){  
        int i=0,j=0;  
        int len1=str1.length(),len2=str2.length();  
        set_next(str2);  
        while(i<len1){//System.out.print(j+" ");  
            if(j==-1||(j<len2&&str1.charAt(i)==str2.charAt(j))){  
                i++;  
                j++;//System.out.print("** ");  
            }else{  
                j=next[j];  
            }//System.out.print(j+"* ");  
        }//System.out.println();  
        if(i==len1){  
            return j;  
        }  
        return 0;  
    }  
}  