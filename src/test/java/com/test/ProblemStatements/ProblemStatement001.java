package com.test.ProblemStatements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProblemStatement001 {

	//total no.of words
	private static int w = 20;
	//total no.of alphabets
	private static int x = 6;
	//total no.of digits
	private static int y = 1;
	//total no.of special characters
	private static int z = 1;

	public static boolean inputRangeIsValid = false;
	public static boolean isPalindrome = false;

	public static void main(String[] args) {

		String word = null;

		try {
		
		//Set no.of letters for alphabets,digits and special charaters in your word
		setWordParameters();
		
		//initial validations on input values based on problem statement limits
		inputRangeIsValid = checkInputValueRange();
		
		if(inputRangeIsValid) {
			word = createWord();
			isPalindrome = isPalindrome(word);
		}

		if(isPalindrome) {
			System.out.println("Valid Palindrome - "+word);
		}
		else
			System.out.println("Invalid Palindrome - "+word);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void setWordParameters() throws Exception{
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("Enter no.of alphabets in your word - ");  
		x= sc.nextInt();  
		System.out.print("Enter no.of digits in your word - ");  
		y= sc.nextInt();  
		System.out.print("Enter no.of special characters in your word - ");  
		z= sc.nextInt();  
		int d=x+y+z;  
		System.out.println("Total letters in your word = " +d);
	}

	public static boolean checkInputValueRange() throws Exception{

		if(w<=0 || w>20) {
			System.out.println("Condition failed - (w<=0 || w>20");
			//glossary();
			return false;
		}
		else if(x<=0 || x>w) {
			System.out.println("Condition failed - x<=0 || x>w");
			//glossary();
			return false;
		}
		else if(y<=0 || y>w) {
			System.out.println("Condition failed - y<=0 || y>w");
			//glossary();
			return false;
		}
		else if(z<=0 || z>w) {
			System.out.println("Condition failed - z<=0 || z>w");
			//glossary();
			return false;
		}
		else if((x+y+z)>w) {
			System.out.println("Condition failed - (x+y+z)>w");
			//glossary();
			return false;
		}
		//else if( (w%2 != 0) || (x%2 != 0) || (y%2 != 0) || (z%2 != 0) )
		//	return false;
		else
			return true;
	}
	
	public static void glossary() {
		System.out.println("Parameters used to create word: ");
		System.out.println("---------------------------------");
		System.out.println("w - Total no.of letters in word: 0<w<=20");
		System.out.println("x - No.of alphabets in your word");
		System.out.println("y - No.of digits in your word");
		System.out.println("z - No.of special characters in your word");
	}

	public static String createWord() throws Exception{

		List<String> alphabets = new ArrayList<String>();
		List<String> digits = new ArrayList<String>();
		List<String> specials = new ArrayList<String>();
		List<String> temp = new ArrayList<String>();

		boolean aflag=false;
		boolean dflag=false;
		boolean sflag=false;

		int i = 0;
		for(i=0; i<x/2; i++) {
			char ch = (char)(97+i);
			alphabets.add(Character.toString(ch));
		}
		if((x%2 != 0)) {
			char ch = (char)(97+i);
			alphabets.add(Character.toString(ch));
			aflag = true;
		}

		int j = 0;
		for(j=0; j<y/2; j++) {
			digits.add(String.valueOf(j));
		}

		if((y%2 != 0)) {
			digits.add(String.valueOf(j));
			dflag = true;
		}

		i = 0;
		int jumpAscii = 0;
		j = 0;
		char ch;
		for(i=0; i<z/2; i++) {

			int val = 0;
			j = 0;
			if(jumpAscii>14) {
				ch = (char)(58+j);
				specials.add(Character.toString(ch));
				j++;
			}
			else {
				ch = (char)(33+i);
				specials.add(Character.toString(ch));
			}
			jumpAscii++;
		}
		if((z%2 != 0)) {
			j = 0;
			if(jumpAscii>14) {
				ch = (char)(58+j);
				specials.add(Character.toString(ch));
				j++;
			}
			else {
				ch = (char)(33+i);
				specials.add(Character.toString(ch));
			}
			jumpAscii++;
			sflag = true;
		}

		//debug System.out.println("Alphabets: "+alphabets);
		//debug System.out.println("Digits: "+digits);
		//debug System.out.println("Specials: "+specials);

		//Storing alphabet value in temp
		for (String s:alphabets) {
			temp.add(s);
		}

		alphabets.addAll(digits); 
		alphabets.addAll(specials);

		StringBuffer sb1 = new StringBuffer();
		for (String s : alphabets) {
			sb1.append(s);
		}

		//debug System.out.println("SB1: "+sb1);

		StringBuffer sb2 = new StringBuffer();

		if(sflag) {
			if(specials.size() != 1)
				specials.remove(0);
			Collections.reverse(specials);
			//System.out.println("Reverse Specials: "+specials);
			for (String s : specials) {
				sb2.append(s);
			}
		}
		else {
			Collections.reverse(specials);
			//System.out.println("Reverse Specials: "+specials);
			for (String s : specials) {
				sb2.append(s);
			}
		}
		//System.out.println("SB2: "+sb2);

		if(dflag) {
			if(digits.size() != 1)
				digits.remove(0);
			Collections.reverse(digits);
			//System.out.println("Reverse Digits: "+digits);
			for (String s : digits) {
				sb2.append(s);
			}
		}
		else {
			Collections.reverse(digits);
			//System.out.println("Reverse Digits: "+digits);
			for (String s : digits) {
				sb2.append(s);
			}
		}
		//System.out.println("SB2: "+sb2);

		if(aflag) {
			if(temp.size() != 1)
				temp.remove(0);
			Collections.reverse(temp);
			//System.out.println("Reverse Alphabets "+temp);
			for (String s : temp) {
				sb2.append(s);
			}
		}
		else {
			Collections.reverse(temp);
			//System.out.println("Reverse Alphabets: "+temp);
			for (String s : temp) {
				sb2.append(s);
			}
		}

		//debug System.out.println("SB2: "+sb2);

		String word = sb1.toString()+sb2.toString();
		//debug System.out.println("Word: "+word);
		return word;
	}

	//Check if input String is Palindrome or not
	static boolean isPalindrome(String str) throws Exception{
		int i = 0, j = str.length() - 1; 

		while (i < j) { 
			if (str.charAt(i) != str.charAt(j)) 
				return false; 
			i++; 
			j--; 
		} 
		return true; 
	} 

}
