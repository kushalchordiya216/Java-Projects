import java.util.*;

class ListImplementation
{
	List <String> list;
	ListImplementation()
	{
		System.out.println("What type of list?\n1.ArrayList\n2.LinkedList\n3.Vector\n4.Stack");
		Scanner sc= new Scanner (System.in);
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			list = new ArrayList<String>();
			break;
		case 2:
			list = new LinkedList<String>();
			break;
		case 3:
			list = new Vector<String>();
			break;
		case 4:
			list = new Stack<String>();
			break;
		}
	}
}

class SetImplementation
{
	Set <String> set;
	SetImplementation()
	{
		System.out.println("What type of set?\n1.HashSet\n2.LinkedHashSet\n3.TreeSet\n");
		Scanner sc= new Scanner (System.in);
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			set = new HashSet<String>();
			break;
		case 2:
			set = new LinkedHashSet<String>();
			break;
		case 3:
			set = new TreeSet<String>();
			break;
		}
	}
}

class QueueImplementation
{
	Queue <String> queue;
	QueueImplementation()
	{
		System.out.println("What type of set?\n1.HashSet\n2.LinkedHashSet\n3.TreeSet\n");
		Scanner sc= new Scanner (System.in);
		int choice = sc.nextInt();
		switch(choice)
		{
		case 1:
			queue = new PriorityQueue<String>();
			break;
		case 2:
			queue = new ArrayDeque <String>();
			break;
		}
	}
}

public class Collections1 
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		ListImplementation list = null;
		SetImplementation set = null;
		QueueImplementation queue = null;
		while (true)
		{
			System.out.println("Work with :\n1.Lists\n2.Sets\n3.Queues\n4.Exit");
			int choice = sc.nextInt();
			boolean a = true;
			switch(choice)
			{
			case 1:
				if(list == null)
				{
					list = new ListImplementation();
				}
				while(a)
				{
					int operation = 0;
					System.out.println("1.Add\n2.Remove\n3.Display\n4.Delete Current Collection\n5.Quit");
					operation = sc.nextInt();
					switch(operation)
					{
					case 1:
						String s = sc.next();
						list.list.add(s);
						break;
					case 2:
						list.list.remove(sc.next());
						break;
					case 3:
						for(String s1:list.list)
						{
							System.out.println(s1);
						}
						break;
					case 4:
						list = null;
						a = false;
						break;
					case 5:
						a = false;
						break;
					default:
						System.out.println("Invalid Choice!");
					}
				}
				break;
			case 2:
				if (set==null)
				{
					set = new SetImplementation();
				}
				while(a)
				{
					System.out.println("1.Add\n2.Remove\n3.Display\n4.Delete current Collection\n5.Quit");
					int operation = sc.nextInt();
					switch(operation)
					{
					case 1:
						set.set.add(sc.next());
						break;
					case 2:
						set.set.remove(sc.next());
						break;
					case 3:
						for(String s:set.set)
						{
							System.out.println(s);
						}
						break;
					case 4:
						set = null;
						a = false;
						break;
					case 5:
						a = false;
						break;
					default:
						System.out.println("Invalid Choice!");
					}
				}
			break;
			case 3:
				if(queue == null)
				{
					queue = new QueueImplementation();
				}
				while(a)
				{
					System.out.println("1.Add\n2.Remove\n3.Display\n4.Delete current collection\n5.Quit");
					int operation = sc.nextInt();
					switch(operation)
					{
					case 1:
						queue.queue.add(sc.next());
						break;
					case 2:
						queue.queue.remove(sc.next());
						break;
					case 3:
						for(String s:queue.queue)
						{
							System.out.println(s);
						}
						break;
					case 4:
						queue = null;
						a = false;
						break;
					case 5:
						a = false;
						break;
					default:
						System.out.println("Invalid Choice!");
					}
				}
			case 4:
				System.exit(1);
				sc.close();
			}
		}
	}
}