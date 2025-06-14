package Abstraction;

public interface Interface2 {

	 void printMethod2();
	 default void printMethod3()
	 {
		 System.out.println("this is a default method");
	 }
	
}
