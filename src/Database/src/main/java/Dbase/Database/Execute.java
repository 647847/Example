package Dbase.Database;


public class Execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySqlConnect o=new MySqlConnect();
		o.dbconnect();
		o.executeStatements();
		//o.insertRecords();
		o.getRecord();
	}

}
