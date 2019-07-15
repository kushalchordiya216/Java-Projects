package jdbc;
import java.util.*;
public class Utils {
	public String QueryParsing(String fields[], String Table){
		String queryStatement = new String();
		queryStatement = "SELECT ";
		for(String f:fields)
		{
			queryStatement += f+',';
		}
		queryStatement.substring(0, queryStatement.length()-1);
		queryStatement += " FROM " + Table;
		return queryStatement;
	}
	
	public void DisplayResults(List<List<String>> rowlist)
	{
		for(List<String> r:rowlist)
		{
			for(String s:r)
			{
				System.out.print("|" + s + "\t\t");
			}
			System.out.print("|");
			System.out.print("\n");
		}
	}
}
