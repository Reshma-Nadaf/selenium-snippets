package Abstraction;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Area ar = new Circel();
		ar.areaDisplay();
		ar.display();
		
		//Interface
		ImplementClass i = new ImplementClass();
		i.printMethod();
		i.printmethod2();
		
		//interface inhheritance
		Interface3 in = new ImplementClass2();
		in.printMethod3();
		
		
	}

}
