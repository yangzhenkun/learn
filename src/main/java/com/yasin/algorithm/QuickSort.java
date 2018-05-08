package com.yasin.algorithm;

public class QuickSort {

	public static void sort(int data[], int left, int right) {
		
		if(left>=right)
			return;
		
		int head = left;
		int tail = right;
		int flag = data[head];
		
		while(head<tail){
			
			while(head<tail&&flag<=data[tail])
				tail--;
			if(head<tail){
				data[head]=data[tail];
				head++;
			}
			
			while(head<tail&&flag>=data[head])
				head++;
			
			if(head<tail){
				data[tail]=data[head];
				tail--;
			}
			
			
		}
		
		
		data[head]=flag;
		
		sort(data,left,head-1);
		sort(data,tail+1,right);
		
		
		
	}

	public static void main(String[] args) {

		int arrs[] = { 5 ,6 ,1, 8, 5, 1, 9, 3, 8, 7 };

		sort(arrs, 0, arrs.length-1);

		for (int i = 0; i < arrs.length; i++) {
			System.out.print(arrs[i]+"   ");
		}
	}

}
