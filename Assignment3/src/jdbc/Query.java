package jdbc;
import java.sql.*;
import java.util.*;
import jdbc.App;

public class Query {
	Connection conn = null;
	Statement stmt = null;
	public List<List<String>> getQuery(String fields,String table,String DBname){
		List<List<String>> rowlist = new LinkedList<List<String>> ();
		try
		{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(App.DB_URL+DBname,App.USER,App.PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT " + fields + " FROM " + table;
	      ResultSet rs = stmt.executeQuery(sql);
	      ResultSetMetaData rsmetadata = rs.getMetaData();
	      int coloumnCount = rsmetadata.getColumnCount();
	      List<String> coloumnnames = new LinkedList<String>();
	      for(int i=1;i<=coloumnCount;i++)
	      {
	    	   coloumnnames.add(rsmetadata.getColumnLabel(i));
	      }
	      rowlist.add(coloumnnames);
	      while(rs.next())  
	      {
	    	  List<String> coloumnlist = new LinkedList<String> ();
	    	  rowlist.add(coloumnlist);
	    	  for(int i=1;i<=coloumnCount;i++)
	    	  {
	    		  Object value = rs.getObject(i);
	    		  coloumnlist.add(String.valueOf(value));
	    	  }
	      }
	      rs.close();
	      stmt.close();
	      conn.close();
	      return rowlist;
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	      //end finally try
	   }//end try
	   System.out.println("Goodbye!");
	   return rowlist;
	}//end main
}
