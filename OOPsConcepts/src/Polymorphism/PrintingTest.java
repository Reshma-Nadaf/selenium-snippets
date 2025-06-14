package Polymorphism;

public class PrintingTest {

	public void printInput(String input)
	{
		System.out.println("prinitng string:"+input);
	}
	
	public void printInput(int a)
	{
		System.out.println("prinitng number:"+ a);
	}
	
	public void printInput(String input, String input2)
	{
		System.out.println("printing the input: "+ input +"and" + input2);
	}
	
	String returnResult(String a, String b)
	{
		return a+b;
	}
}
