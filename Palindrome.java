package companyname.projectname.modulename;

import java.util.Scanner;
import java.io.*;

public class Palindrome {

	public static boolean isNumber(String str) {
		if(str==null)
			return false;
		try {
			int num = Integer.parseInt(str);
		}catch(NumberFormatException numForExc){
			return false;
		}
		return true;
	}
	
	public static boolean isPalindrome(String str) {
		StringBuilder temp = new StringBuilder();
		temp.append(str);
		temp.reverse();
		
		if(str.equals(temp.toString())) {
			return true;
		}
		
		else
			return false;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		
		if(isPalindrome(str)) {
			if(isNumber(str))
				System.out.println("The Number is Palindrome");
			else
				System.out.println("The String is Palindrome");
		}
		else {
			if(isNumber(str))
				System.out.println("The Number is not Palindrome");
			else
				System.out.println("The String is not Palindrome");
		}
	}

}
