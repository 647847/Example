import java.util.*;
public class MapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map m=new HashMap();
		m.put(1, "Coffee");
		m.put(2, "Tea");
		m.put(3, "Black coffee");
		m.put(4, "Lemon tea");
		 Set e=m.entrySet();
		 System.out.println(e);
		 
		 String str=(String)m.get(1);
		 System.out.println(str);
		 for(Object o:m.entrySet())
			 System.out.println(o);
		 Set k=m.keySet();
		 System.out.println(k);
		 Collection v=m.values();
		 System.out.println(v);
			 
		

	}

}
