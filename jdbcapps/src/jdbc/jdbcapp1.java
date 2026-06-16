package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcapp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connection with Db
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "sravanthi");
			//create statement
		   Statement st=con.createStatement();
		   //prepare and parse the query
		   //String qry="create table product(pid int,pname char(10),price double)";
		   //String qry2="insert into product values(123,'mobile',657890)";
		   //taking dynamic inputs
		   Scanner s=new Scanner(System.in);
		   int id=s.nextInt();
		   String name=s.next();
		   double price=s.nextDouble();
		   String qry3="insert into product values("+id+",'"+name+"',"+price+")";
		   //execute the query
		   int x=st.executeUpdate(qry3);
		   //get the result
		   System.out.println(x);
		   System.out.println("row created");
		   ResultSet rs=st.executeQuery("select * from product");
		   st.close();
		   con.close();
		   
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
