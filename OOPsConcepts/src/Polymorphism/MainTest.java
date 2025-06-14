package Polymorphism;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChildPrintingTest c = new ChildPrintingTest();

		PrintingTest p = new PrintingTest();
		c.printInput(12);
		c.printInput("new string");
	    c.printInput("new string", "old input");
		
		c.printInput("overridenmthod");
		
		p.printInput("original method");

		System.out.println(c.returnResult(8, 9));
		System.out.println(c.returnResult("res", "kir"));

	}

}
