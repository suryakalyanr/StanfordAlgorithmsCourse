package com.suryakalyanr.algos;

public class BigIntMultiplier {
	
	public static void main(String[] args) {
		
		String s1 = "3141592653589793238462643383279502884197169399375105820974944592";
		String s2 = "2718281828459045235360287471352662497757247093699959574966967627";
		
		int[] num1 = new int[s1.length()];
		
		for (int i = 0 ; i < s1.length(); i++) {
			num1[s1.length()-i-1] = s1.charAt(i) - '0';
		}
		
		
		int[] num2 = new int[s2.length()];
		for (int i = 0 ; i < s2.length(); i++ ) {
			num2[s2.length()-i-1] = s2.charAt(i) - '0';
		}
		
		int[] product = gradeSchoolMultiplication(num1, num2);
		
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println("--------------");
		
		for (int i = product.length-1 ; i >=  0; i--) 
			System.out.print(product[i]);
		
	}
	
	public static int[] gradeSchoolMultiplication(int[] num1, int[] num2) {
		int[][] prodMatrix = new int[num2.length][num1.length + num2.length];
		
		for (int i = 0 ; i < num1.length+ num2.length ; i++) 
			for (int j = 0 ; j < num2.length ; j++) 
				prodMatrix[j][i] = 0;
		
		
		int[] product = new int[num1.length + num2.length];
		
		int carry = 0;
		
		for (int i = 0 ; i < num2.length ; i++) {
			carry = 0;
			for (int j = 0 ; j < num1.length ; j++) {
				
				int p = (num2[i] * num1[j]) + carry;
				carry = p / 10;
				prodMatrix[i][i+j] = p % 10;
			}
			prodMatrix[i][i+num1.length] = carry;
		}
		
		carry = 0;
		int sum = 0;
		
		for (int i = 0 ; i < num1.length + num2.length ; i++) {
			sum = 0;
			for (int j = 0 ; j < num2.length ; j++) {
				sum += prodMatrix[j][i]; 
			}
			sum += carry;
			product[i] = sum % 10;
			carry = sum / 10;
		}	
		
		return product;
		
		
	}

}
