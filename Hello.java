package companyname.projectname.modulename;

import java.util.Scanner;

public class Hello {
	static int ch;
	static {
		System.out.println("1) Create\n2) Display\n3) Raise Salary\n4) Exit");
		Scanner sc = new Scanner(System.in);
		ch=sc.nextInt();
		if(ch==1)
			System.out.println("Ch1 choosed");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello World");
	}

}
