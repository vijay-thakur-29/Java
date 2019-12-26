package oops;

public class Finall 
{

	public static void main(String[] args) 
	{
	try
	{
		int c;
		int i=10;
		int b=2;
		c=i/b;
		System.out.println("The answer is:"+c);
	}
	catch(NullPointerException e)
	{
		System.out.println("Inside Catch block");
	}
	finally
	{
		System.out.println("Out of Code");
	}
	}

}
