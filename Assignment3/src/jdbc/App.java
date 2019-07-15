package jdbc;

import java.util.*;
import jdbc.Utils;
import jdbc.Query;

public class App {
	 // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://10.10.11.242:3306/";

   //  Database credentials
   static final String USER = "te3319";
   static final String PASS = "te3319";
   
   public static void main(String[] args) {
	   
	   Scanner sc = new Scanner(System.in);
	   boolean a = true;
	   while(a){
		    System.out.println("1.Query\n2.Insert New Entry\n3.Update exisiting\n4.Delete\n5.Create New Table\n6.Delete Table\n7.Exit");
	   		int choice = sc.nextInt();
	   		switch(choice)
	   		{
	   			case 1:
	   				System.out.println("Enter DB Name");
	   				String DBname = sc.next();
	   				System.out.println("Enter the tablename");
	   				String table = sc.next();
	   				System.out.println("Enter the fields you want to query, as commas separated values");
	   				String fields = sc.next();
	   				Utils utils = new Utils();
	   				Query query = new Query();
	   				utils.DisplayResults(query.getQuery(fields, table, DBname));
	   				break;
	   			case 2:
	   				
	   			default:
	   				System.out.println("YEET!\n");
	   		}
	   }
   }
}
