class GenericDemo <T>
{
	T obj;
	GenericDemo(T x)
	{
		this.obj = x;
	}
	
	void display(T elements[])
	{
		for(T x:elements)
		{
			System.out.println(x);
		}
	}
}

public class Generics1 
{
	public static void main (String args[])
	{
		GenericDemo <Integer> g = new GenericDemo <Integer> (15);
		
		
	}
}
