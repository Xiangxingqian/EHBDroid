package com.app.test;

import java.util.ArrayList;
import java.util.List;

public class MathUtil {
	
	//��n��Ԫ�ؽ������У���ȡm�����С�����5��Ԫ���ܹ���120��ȫ���У���Nȡ5ʱ���������5�����С�
	public static List<List<Integer>> getNPermutation(int N, int elements){
		ArrayList<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<List<Integer>> sortInt = sortInt(elements);
		List<Integer> random = random(N,sortInt.size());
		for(Integer integer:random)
			ll.add(sortInt.get(integer));
		return ll;
	}
	
	//���n������m��������������(5,100)������100���ڵ����5������ 
	private static List<Integer> random(int m, int n){
		ArrayList arr = new ArrayList<Integer>();
		int min = m<n?m:n;
		for(int t = 0;arr.size()<min;t++){
			int index = (int) (Math.random()*n);
			if(!arr.contains(index))
				arr.add(index);
		}
		return arr;
	}
	
	//���[0,i)��ȫ����
	public static List<List<Integer>> sortInt(int i){
		ArrayList<Integer> integers = new ArrayList<Integer>();
		for(int t=0;t<i;t++){
			integers.add(t);
		}
		return sort(integers);
	}
	
	//����б�list��ȫ����
	public static List<List<Integer>> sort(ArrayList<Integer> list){
		ArrayList<List<Integer>> ll = new ArrayList<List<Integer>>();
		if(list.size()==1){
			ll.add(list);
			return ll;
		}
		for(Integer i:list){
			ArrayList clone = (ArrayList)list.clone();
			clone.remove(i);
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			arrayList.add(i);	
			for(List<Integer> list2:sort(clone)){
				ArrayList<Integer> clone2 = (ArrayList<Integer>)arrayList.clone();
				clone2.addAll(list2);
				ll.add(clone2);
			}
		}
		return ll;
	}
}
