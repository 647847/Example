package DbCase.DBcase;
import java.sql.*;
public class CallRating {
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
		String query1="create table callQuality(callid int primary key,phoneno varchar(20),callfeedback varchar(200),callrating int,customername varchar(20),droprate varchar(20))";
		try {
			stat=con.createStatement();
			boolean result=stat.execute(query1);
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
		String insertCom="insert into callQuality values(3,' 888938980','call drops',2,'Nick','28%'),(4,'6576877879','signal',3,'Carrie','40%'),(5,'45465676890','call quality',3,'James','34%')";
		try {
			int rec=stat.executeUpdate(insertCom);
			System.out.println("record inserted"+rec);
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}
	public void getRecord() {
		String query="select * from callQuality where droprate='30%'";
		try {
			ResultSet res=stat.executeQuery(query);
			while(res.next()) {
				int callid=res.getInt(1); 
				String phonenumber=res.getString(2);
				String callfeedback=res.getString(3);
				int callrating=res.getInt(4);
				String customername=res.getString(5);
				String droprate=res.getString(6);
				System.out.println("callid:"+callid);
				System.out.println("phonenumber:"+phonenumber);
				System.out.println("call feedback:"+callfeedback);
				System.out.println("call rating:"+callrating);
				System.out.println("customer name:"+customername);
				System.out.println("drop rate:"+droprate);
			}
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	
	}
	public void insertParRecords(int callid,String phonenumber,String callfeedback,int callrating,String customername,String droprate) {
		String que="insert into callQuality values(?,?,?,?,?,?)";
		try {
			PreparedStatement st=con.prepareStatement(que);
			st.setInt(1, callid);
			st.setString(2, phonenumber);
			st.setString(3, callfeedback);
			st.setInt(4, callrating);
			st.setString(5, customername);
			st.setString(6, droprate);
			int rec_ins=st.executeUpdate();
			System.out.println("record inserted"+rec_ins);
			
			}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void showRecords(int callrate) {
	    String query = "select * from callquality where callrating > ?";
	    try {
	        PreparedStatement stat = con.prepareStatement(query);
	        stat.setInt(1,callrate );
	        ResultSet res = stat.executeQuery();
	        while (res.next()) 
	        {
	        	int callid=res.getInt("callid");
				String phonenumber=res.getString("phoneno");
				String callfeedback=res.getString("callfeedback");
				int callrating=res.getInt("callrating");
				String customername=res.getString("customername");
				String droprate=res.getString("droprate");
				System.out.println("call id:"+callid);
				System.out.println("phoneNo:"+phonenumber);
				System.out.println("feedback:"+callfeedback);
				System.out.println("callrating:"+callrating);
				System.out.println("customername:"+customername);
				System.out.println("calldrop:"+droprate);
	            
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
}
