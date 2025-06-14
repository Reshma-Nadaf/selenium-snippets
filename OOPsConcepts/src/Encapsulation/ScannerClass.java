package Encapsulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner obj = new Scanner(System.in);
		System.out.println("enter input");
		
		
		List<String>l = new ArrayList<>();
		
		for (int i=0; i<=5; i++)
		{
			String input = obj.nextLine();
			l.add(input);
		}
		
		
		System.out.println(l);
	}

}
