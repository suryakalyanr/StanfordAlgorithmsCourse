package com.algos.week2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class QuickSortImpl {
	
	public int[] arr;
	public int totComp = 0;
	
	
	QuickSortImpl() {
		arr = new int[]{1,5,4,3,2,6,9,8,7,0};
	}
	
	QuickSortImpl(String filename) {
		
		arr = new int[10000];
		totComp = 0;
		
		try {
			
			File f = new File(this.getClass().getResource("/"+filename).toURI());
		
			FileReader fr = new FileReader(f);
			
			BufferedReader br = new BufferedReader(fr);
			
			String str = null;
			
			int i = 0;
			
			while ((str = br.readLine())!=null) {
				arr[i] = Integer.parseInt(str);
				i++;
			}
			
			br.close();
			fr.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	private void exchangeNumbers(int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void sortUsingQuickSort() {
		
		if (arr == null || arr.length == 0)
			return;
		
		quickSort(0, arr.length-1);
		
	}
	
	private void quickSort(int low, int high) {
		
		if (low < high) {
			
			totComp += (high-low);			
			
			int partition = partition(low, high);
			quickSort(low, partition-1);
			quickSort(partition+1, high);
			
		}
	}
	
	private int partition(int left, int right) {
		
//		int pivotPos   = left; //162085
//		int pivotPos   = right;  //164123
	
		int middle   = left + (right - left)/2; //150657 //138382
		int pivotPos = middle;
		
		if ((arr[left] < arr[middle] && arr[middle] < arr[right]) || 
				(arr[right] < arr[middle] && arr[middle] < arr[left])) {
			pivotPos = middle;
		} 
		else {
			if ((arr[middle] < arr[left] && arr[left] < arr[right]) || (arr[right] < arr[left] && arr[left] < arr[middle] ))
			{
				pivotPos = left;
			} else {
				
				if ((arr[left] < arr[right] && arr[right] < arr[middle]) || (arr[middle] < arr[right] && arr[right] < arr[left])) {
					pivotPos = right;
				}
			}
		}
		
		
		exchangeNumbers(left, pivotPos);
		

		
	    int pivotValue = arr[left]; 
	    
	    int i = left+1;
	    
	    for (int j = left+1 ; j <= right ; j++) {
	    	
	    	if (arr[j] < pivotValue) {
	    		if (i != j)
	    			exchangeNumbers(i, j);
	    		i++;
	    	}
	    }
	    
	    exchangeNumbers(left, i-1);
	    
	    //displayArray();
	    
	    return i-1;
	    
	}
	
	
	public void displayArray() {
		for (int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		QuickSortImpl m1 = new QuickSortImpl("QuickSort.txt");
//		QuickSortImpl m1 = new QuickSortImpl();
		
		m1.sortUsingQuickSort();
		
		for (int i : m1.arr) {
			System.out.println(i);
		}
		System.out.println("----------");
		System.out.println(m1.totComp);
		
		
	}
	
	

}
