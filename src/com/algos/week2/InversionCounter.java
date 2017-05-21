package com.algos.week2;

import java.io.BufferedReader;
import java.io.FileReader;

public class InversionCounter {
	
	int[] arr = new int[100000];
	
	
	InversionCounter() {
		arr = new int[]{1,5,4,3,2,6,9,8,7,0};
	}
	
	InversionCounter(String filename) {
		
		try {
		
			FileReader fr = new FileReader(filename);
			
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
	
	
	public static void main(String[] args) {

		InversionCounter inv = new InversionCounter("C:\\Users\\abhi_\\Desktop\\IntegerArray.txt");
	
		System.out.println(inv.countInversionsBruteForce());
	
	}
	
	
	public long countInversionsBruteForce() {
		long sum = 0;
		 
		for (int i = 0 ; i < arr.length ; i++) {
			
			for (int j = i+1 ; j < arr.length ; j++) {
				
				if (arr[i] > arr[j])
					sum++;
			}
		}
		
		
		return sum;
	}
	

}
