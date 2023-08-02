import java.util.*;
public class CollectionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l=new ArrayList();
		l.add("Coffee");
		l.add("Ice Tea");
		l.add("Regular Tea");
		l.add("Lemon Tea");
		l.add("Black coffee");
		l.add("Capaccuino");
		ListIterator ite=l.listIterator();
		System.out.println("Printing through list iterator .................");
		while(ite.hasNext()) {
			System.out.println(ite.next()+" ");
			
		}
		System.out.println("Removing........");
		l.remove(4);
		System.out.println(l);
		System.out.println("Getting ........");
		System.out.println(l.get(2));
		
		

	}

}
