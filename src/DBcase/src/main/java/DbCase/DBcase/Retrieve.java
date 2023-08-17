package DbCase.DBcase;

public class Retrieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallRating c=new CallRating();
		c.dbconnect();
		c.executeStatements();
		//c.insertParRecords(6,"76898096767","call drops",3,"Dames","20%");
		//c.insertParRecords(7,"546789890009","signal",2,"Sofia","40%");
		c.showRecords(2);
		//c.insertRecords();
		c.getRecord();
	}

}
