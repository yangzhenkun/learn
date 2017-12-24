package com.yasin.algorithm;

public class QuickSort {

	public static void sort(int arr[], int low, int high) {

		int l = low;
		int h = high;
		int povit = arr[low];

		while (l < h) {
			while (l < h && arr[h] >= povit)
				h--;
			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				l++;
			}

			while (l < h && arr[l] <= povit)
				l++;

			if (l < h) {
				int temp = arr[h];
				arr[h] = arr[l];
				arr[l] = temp;
				h--;
			}
		}

		if (l > low)
			sort(arr, low, l - 1);
		if (h < high)
			sort(arr, l + 1, high);

	}

	public static void main(String[] args) {

		int arrs[] = { 5 ,6 ,1, 8, 5, 1, 9, 3, 8, 7 };

		sort(arrs, 0, arrs.length-1);

		for (int i = 0; i < arrs.length; i++) {
			System.out.print(arrs[i]+"   ");
		}
	}

}
