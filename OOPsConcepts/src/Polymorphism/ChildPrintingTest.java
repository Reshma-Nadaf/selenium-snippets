package Polymorphism;

public class ChildPrintingTest extends PrintingTest{
	
	public void printInput(String input)
	{
		System.out.println("overridding the method:" +input);
	}

	int returnResult(int a, int b)
	{
		return (a+b);
	}
}
