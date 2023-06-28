package adt.heap.extended;


import java.util.*;

public class HeapMergeImpl extends PriorityQueue<Integer> implements HeapMerge {

	@Override
	public Integer[] mergeArraysAndOrder(List<Integer[]> arrays) {
		int cont = 0;
		for (int i = 0; i < arrays.size(); i++) {
			for (int j = 0; j < arrays.get(i).length; j++) {
				this.add(arrays.get(i)[j]);
				cont++;
			}
		}
			Integer[] list = new Integer[cont];
		int aux = 0;
			while (!this.isEmpty()){
				list[aux] = this.poll();
				aux++;
			}
			return list;

	}

	@Override
	public int sumRange(int k1, int k2) {
		int sum = 0;

		while(k1 > 0 && !this.isEmpty()){
			k1--;
			k2--;
			this.poll();
		}
			while (!this.isEmpty() && k2 > 1){
					sum += this.poll();
					k2--;
				}
		return sum;
	}
	public static void main(String[] args) {
		HeapMergeImpl h = new HeapMergeImpl();

		// testando a primeira questão
		Integer[] a1 = { 5, 9, 6, 4, 1, 2, 3, 0, 100 };
		Integer[] a2 = { 7, 8, 15, -1, -5 };
		Integer[] a3 = { -10, 11, 40, 30 };
		Integer[] a4 = { -8, 12, 33, 99 };

		List<Integer[]> l = new LinkedList<Integer[]>();
		l.add(a1);
		l.add(a4);
		l.add(a3);
		l.add(a2);

		System.out.println(Arrays.toString(h.mergeArraysAndOrder(l)));

		// testando a segunda questão
		Integer[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17 };
		for (Integer i : array) {
			h.add(i);
		}

		System.out.println(h.sumRange(3, 8));

	}
}
