package Cust.Customer;
import java.sql.*;

public class Customer {
	public static final String url="jdbc:mysql://localhost:3306/test";
	public static final String username="root";
	public static final String password="admin";
	Connection con;
	Statement stat;
	public void dbconnect(){
	try {
		con=DriverManager.getConnection(url,username,password);
		System.out.println("connection established");
		System.out.println(con.getMetaData().getDatabaseProductName());
		System.out.println(con.getClientInfo());
		
	}
	catch(Exception e) {
		System.out.println(e);
		
	}
	}
	public void executeStatements() {
		String query2="create table package(packid int primary key,packname varchar(20),rate int,days int)";
		String query1="create table customer1(custid int primary key,fname varchar(20),lname varchar(20),phoneno varchar(20),amount int,due_date varchar(20),address varchar(20),packid int,foreign key(packid) references package(packid))";
		
		try {
			stat=con.createStatement();
			boolean result1=stat.execute(query2);
			boolean result2=stat.execute(query1);
			
			if(result2 && result1) {
				System.out.println("Tables not created");
			}
			else {
				System.out.println("Tables created");
			}
			
			
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
	}
	public void batchQuery(){
		
		try {
			con.setAutoCommit(false);
			stat.addBatch("insert into customer1 values(678,'Nick','Jones','783493849034',50,'7-8-23','Hyd',1)");
			stat.addBatch("insert into customer1 values(758,'James','Bond','765587347583',40,'8-7-23','Mumbai',2)");
			stat.addBatch("insert into customer1 values(678,'Erric','Peter','9497783783',30,'5-7-23','Pune',3)");
			stat.addBatch("insert into package values(1,'pens',45,6)");
			stat.addBatch("insert into package values(2,'pencils',90,4)");
			stat.addBatch("insert into package values(3,'toys',5,2)");
			int [] results=stat.executeBatch();
			con.commit();
			for(int i:results) {
				System.out.println(i);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
			try {
				con.rollback();
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
		}
		}
}
