package Dbase.Database;
import java.sql.*;
import java.sql.DriverManager;

public class MySqlConnect {
	public static final String url="jdbc:mysql://localhost:3306/world";
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
		String query="create table items(itemid int primary key,itemname varchar(20))";
		try {
			stat=con.createStatement();
			boolean result=stat.execute(query);
			if(result) {
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
	public void insertRecords() {
		String insertCom="insert into items values(2,'Ice Tea')";
		try {
			int rec=stat.executeUpdate(insertCom);
			System.out.println("record inserted"+rec);
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}
	public void getRecord() {
		String query="select * from items";
		try {
			ResultSet res=stat.executeQuery(query);
			while(res.next()) {
				int itemid=res.getInt(1);
				String itemName=res.getString(2);
				System.out.println("item id:"+itemid);
				System.out.println("item name:"+itemName);
			}
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
	}

}
