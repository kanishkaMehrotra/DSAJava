package practiceJavaInterviews;

public class InheritenceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a1=new Animal();
		a1.print();
		System.out.println(a1 instanceof Dog);
		Animal a2=new Dog();
		//System.out.println(Animal instanceof Dog);
		a2.print();
		Dog d=(Dog) new Animal();
		d.print();
		d.print2();

	}

}
class Animal
{
	public void print()
	{
		System.out.println("inside Animal");
	}
	
}

class Dog extends Animal
{
	public void print()
	{
		System.out.println("inside Dog");
	}
	public void print2()
	{
		System.out.println("print 2");
	}
	
}